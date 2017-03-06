package es.onebox.rest.utils.model;

import es.onebox.rest.utils.utils.ResponseErrorCodesEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * DTO that stores Onebox REST API request and response parameters.
 *
 * @author Oreste Luci
 */
public class ResponseDTO {

    // Request parameters
    private String stringToSign;
    private String authorization;
    private HttpHeaders httpHeaders;
    private Date date;

    // Response from Onebox REST
    private ResponseEntity<String> responseEntity;
    private Exception error;
    private String additionalErrorMessage;
    private ResponseErrorCodesEnum obResponseErrorCode;

    public ResponseErrorCodesEnum getObResponseErrorCode() {
        return obResponseErrorCode;
    }

    public void setObResponseErrorCode(ResponseErrorCodesEnum obResponseErrorCode) {
        this.obResponseErrorCode = obResponseErrorCode;
    }

    public String getAdditionalErrorMessage() {
        return additionalErrorMessage;
    }

    public void setAdditionalErrorMessage(String additionalErrorMessage) {
        this.additionalErrorMessage = additionalErrorMessage;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ResponseEntity<String> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<String> responseEntity) {
        this.responseEntity = responseEntity;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public String getStringToSign() {
        return stringToSign;
    }

    public void setStringToSign(String stringToSign) {
        this.stringToSign = stringToSign;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public int getBodySizeInKilobytes() {

        if (responseEntity!=null && responseEntity.getBody()!=null) {

            int bytes = responseEntity.getBody().getBytes().length / 1024;

            return bytes;

        } else {
            return 0;
        }
    }

    public int getBodySizeInBytes() {

        if (responseEntity!=null && responseEntity.getBody()!=null) {

            int bytes = responseEntity.getBody().getBytes().length;

            return bytes;

        } else {
            return 0;
        }
    }
}
