package es.onebox.rest.utils.model.communication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="banner",namespace="http://www.oneboxtm.es/ns/communication")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BannerBean {

    @XmlAttribute(name="type")
    @JsonProperty("@type")
    private String type;

    @XmlElement(name="imageUrl")
    @JsonProperty("imageUrl")
    private String imageUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
