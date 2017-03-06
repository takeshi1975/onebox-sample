package es.onebox.rest.utils.controllers;

import es.onebox.rest.utils.model.ErrorCode;
import es.onebox.rest.utils.utils.ResponseErrorCodesEnum;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oreste Luci
 */
@RestController
@RequestMapping("/restAPIErrorCodes")
public class RestAPIErrorCodesController {

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<ErrorCode> getErrorCodes() {

        List<ErrorCode> errorCodes = new ArrayList<>();

        ResponseErrorCodesEnum[] errorCodesValues = ResponseErrorCodesEnum.values();

        for (ResponseErrorCodesEnum code : errorCodesValues) {
            ErrorCode errorCode = new ErrorCode(code);
            errorCodes.add(errorCode);
        }

        return errorCodes;
    }
}
