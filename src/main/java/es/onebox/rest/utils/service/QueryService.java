package es.onebox.rest.utils.service;

import es.onebox.rest.utils.model.AuthenticationForm;
import es.onebox.rest.utils.model.QueryForm;
import es.onebox.rest.utils.model.ResponseDTO;
import es.onebox.rest.utils.utils.AppUtils;
import es.onebox.rest.utils.utils.ResponseErrorCodesEnum;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.MultiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.Charset;
import java.security.SignatureException;
import java.util.*;

/**
 * This service provides the logic to send request to Onebox REST API.
 *
 * It has methods to generate String to be signed and the method to perform the signature.
 *
 * @author Oreste Luci
 */
@Service
public class QueryService {

    private static final Logger logger = LoggerFactory.getLogger(QueryService.class);

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final String UTF_8 = "UTF-8";
    private static final String AMPERSAND = "&";
    private static final String PARAM_NAME_VALUE_SEPARATOR = "=";
    private static final String HMAC_FIELD_SEPARATOR = "\n";
    private static final String URI_PARAMETERS_SEPARATOR = "?";
    private static final String PARAMETERS_SEPARATOR = "&";
    private static final String AUTHORIZATION_HEADER_HMAC_PREFIX = "OB_HMAC ";

    /**
     * Main method to perform request to Onebox REST API.
     *
     * @param authenticationForm
     * @param queryForm
     * @return Response form request
     */
    public ResponseDTO query(AuthenticationForm authenticationForm,QueryForm queryForm) {

        ResponseDTO responseDTO = new ResponseDTO();
        Exception ex = null;

        try {

            URL url = new URL(queryForm.getUrl());
            URI uri = url.toURI();

            Date date = new Date();
            long timestamp = date.getTime();

            HttpMethod httpMethod;

            if (queryForm.getMethod().equalsIgnoreCase("post")) {
                httpMethod = HttpMethod.POST;
            } else {
                httpMethod = HttpMethod.GET;
            }

            // Getting String to encode with HMAC-SHA1
            // First step in the signing algorithm
            String stringToSign = getStringToSign(uri, httpMethod.name(), timestamp, queryForm);

            logger.info("String to sign: " + stringToSign);

            // Encoding String
            // This is the actual authorization string that will be sent in the request
            String authorization = generate_HMAC_SHA1_Signature(stringToSign,authenticationForm.getPassword() + authenticationForm.getLicense());

            logger.info("Authorization string: " + authorization);

            // Adding to return object
            responseDTO.setDate(date);
            responseDTO.setStringToSign(stringToSign);
            responseDTO.setAuthorization(authorization);

            // Setting Headers
            HttpHeaders headers = new HttpHeaders();

            if (queryForm.getAccept().equals("json")) {
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            } else {
                headers.setAccept(Arrays.asList(MediaType.TEXT_XML));
            }

            headers.add("Authorization", authorization);
            headers.add("OB_DATE", ""+timestamp);
            headers.add("OB_Terminal", authenticationForm.getTerminal());
            headers.add("OB_User", authenticationForm.getUser());
            headers.add("OB_Channel", authenticationForm.getChannelId());
            headers.add("OB_POS", authenticationForm.getPos());

            // Adding Headers to return object
            responseDTO.setHttpHeaders(headers);

            HttpEntity<String> entity;

            if (httpMethod == HttpMethod.POST) {
                // Adding post parameters to POST body
                String parameterStringBody = queryForm.getParametersAsString();
                entity = new HttpEntity<String>(parameterStringBody, headers);
                logger.info("POST Body: " + parameterStringBody);
            } else {
                entity = new HttpEntity<String>(headers);
            }

            // Creating rest client
            RestTemplate restTemplate = new RestTemplate();

            // Converting to UTF-8. OB Rest replies in windows charset.
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

            // Performing request to Onebox REST API
            ResponseEntity<String> result = restTemplate.exchange(uri, httpMethod, entity, String.class);

            // TODO this functionlity is to map response to objetcs. It is not finished. Only placed here for POC
            /*
            if (queryForm.getMapResponse().booleanValue()) {
                ResponseEntity<EventSearchBean> event = restTemplate.exchange(uri, httpMethod, entity, EventSearchBean.class);
            }
            */

            // Adding response to return object
            responseDTO.setResponseEntity(result);

            logger.debug(result.toString());

        } catch (HttpClientErrorException e) {
            logger.error(e.getMessage());
            ex = e;
            e.printStackTrace();
            responseDTO.setError(e);
            responseDTO.setAdditionalErrorMessage(AppUtils.getMessage("error.request.parameters"));
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
            ex = e;
            e.printStackTrace();
            responseDTO.setError(e);
            responseDTO.setAdditionalErrorMessage(AppUtils.getMessage("error.request.parameters"));
        } catch (SignatureException e) {
            logger.error(e.getMessage());
            ex = e;
            e.printStackTrace();
            responseDTO.setError(e);
            responseDTO.setAdditionalErrorMessage(AppUtils.getMessage("error.request.parameters"));
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
            ex = e;
            e.printStackTrace();
            responseDTO.setError(e);
            responseDTO.setAdditionalErrorMessage(AppUtils.getMessage("error.request.parameters"));
        } catch (Exception e) {
            logger.error(e.getMessage());
            ex = e;
            e.printStackTrace();
            responseDTO.setError(e);
            responseDTO.setAdditionalErrorMessage(AppUtils.getMessage("error.request.authentication"));
        } finally {
            if (ex!=null && ex instanceof HttpServerErrorException) {
                HttpServerErrorException e2 = (HttpServerErrorException)ex;
                ResponseEntity<String> responseEntity = new ResponseEntity<String>(e2.getResponseHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);

                List<String> ob_error_codes = e2.getResponseHeaders().get("OB_Error_Code");

                String ob_error_code;
                ResponseErrorCodesEnum ob_error=null;

                if (ob_error_codes!=null && ob_error_codes.size()==1) {
                    ob_error_code = ob_error_codes.get(0);
                    try {
                        ob_error = ResponseErrorCodesEnum.valueOf("ERROR_" + ob_error_code);
                    } catch (Exception e) {
                        logger.error("API ERROR CODE NOT DEFINED: " + "ERROR_" + ob_error_code);
                    }
                    responseDTO.setObResponseErrorCode(ob_error);
                }

                responseDTO.setResponseEntity(responseEntity);
            }
        }

        return responseDTO;
    }

    /**
     * This method generates the string to be signed based on the following rules:
     *
     *  - Add the request method + \n
     *  - Add the timestamp + \n
     *  - Add the request URI
     *  - For each request parameter ordered alphabetically:
     *    - First parameter delimiter ?
     *    - Other parameters separated by &
     *    - Name of the parameter
     *    - Add ´=´ sign
     *    - value of the parameter
     *
     * For example:
     *
     *   Given a GET request with timestamp = 1316430943576 and uri = /uri_path/ejemplo with parameters,
     *     Bc = 'Prueba1'
     *     Aa = 'Prueba2'
     *     bc = 'aPrueba3'
     *     z1 = 'prueba4'
     *
     *   The String to sign is:
     *
     *     GET\n1316430943576\n/uri_path/ejemplo?amp;Aa=Prueba2&bc=aPrueba3&Bc=Prueba1&z1=prueba4
     *
     * @param uri
     * @param method
     * @param timestamp
     * @return
     * @throws SignatureException
     */
    private String getStringToSign(URI uri,String method, long timestamp, QueryForm queryForm) throws SignatureException {

        SortedMap<String,String> sortedMap = new TreeMap<String, String>();

        // Assuming GET. It actually processes URL parameters for all Method types
        if (uri.getRawQuery()!=null) {

            StringTokenizer tokenizer = null;
            try
            {
                tokenizer = new StringTokenizer(URLDecoder.decode(uri.getRawQuery(), UTF_8),AMPERSAND);
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            while(tokenizer.hasMoreElements())
            {
                String token = tokenizer.nextToken();
                sortedMap.put(token.split(PARAM_NAME_VALUE_SEPARATOR)[0].toLowerCase()+token.split(PARAM_NAME_VALUE_SEPARATOR)[1], token);
            }
        }

        // If POST process parameter map
        if(method.equals(HttpMethod.POST.name()))
        {
            for (String key : ((Set<String>)((MultiMap)queryForm.getFormParameters()).keySet())) {
                for (String valor : ((List<String>) ((MultiMap) queryForm.getFormParameters()).get(key))){
                    sortedMap.put(key.toLowerCase()+PARAM_NAME_VALUE_SEPARATOR+valor,key+ PARAM_NAME_VALUE_SEPARATOR +valor);
                }
            }


        }

        // Generating String to sign
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(method);
        stringToSign.append(HMAC_FIELD_SEPARATOR).append(timestamp);
        stringToSign.append(HMAC_FIELD_SEPARATOR).append(uri.getPath());

        boolean firstParam=true;

        for (String param : sortedMap.values())
        {
            if(firstParam)
            {
                stringToSign.append(URI_PARAMETERS_SEPARATOR).append(param);
                firstParam=false;
            }
            else
            {
                stringToSign.append(PARAMETERS_SEPARATOR).append(param);
            }
        }

        return stringToSign.toString();
    }

    /**
     * Signs a string with the given key.
     *
     * @param data
     * @param key
     * @return
     * @throws SignatureException
     */
    private String generate_HMAC_SHA1_Signature(String data, String key) throws SignatureException
    {
        String result;

        try
        {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(UTF_8), HMAC_SHA1_ALGORITHM);

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes(UTF_8));
            byte[] base64 = Base64.encodeBase64(rawHmac);

            // base64-encode the hmac
            result = new String(base64);
        }
        catch (Exception e)
        {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }

        return AUTHORIZATION_HEADER_HMAC_PREFIX + result;
    }
}
