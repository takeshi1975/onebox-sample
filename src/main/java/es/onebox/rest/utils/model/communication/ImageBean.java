package es.onebox.rest.utils.model.communication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="image",namespace="http://www.oneboxtm.es/ns/communication")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageBean {

    @XmlAttribute(name="type")
    @JsonProperty("@type")
    private String type;

    @XmlAttribute(name="order")
    @JsonProperty("@order")
    private Integer order;

    @XmlValue
    @JsonProperty("$")
    private String image;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
