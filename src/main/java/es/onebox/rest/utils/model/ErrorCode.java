package es.onebox.rest.utils.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.onebox.rest.utils.utils.ResponseErrorCodesEnum;

/**
 * @author Oreste Luci
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorCode {

    private String code;
    private String name;
    private String description;

    public ErrorCode(ResponseErrorCodesEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.name = errorCodeEnum.getName();
        this.description = errorCodeEnum.getDescription();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
