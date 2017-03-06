package es.onebox.rest.utils.model.communication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="communication-elements",namespace="http://www.oneboxtm.es/ns/communication")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunicationElementsBean {

    @XmlAttribute(name="language")
    @JsonProperty("@language")
    private String language;

    @XmlElement(name="images")
    @JsonProperty("images")
    private ImagesBean images;

    @XmlElement(name="banners")
    @JsonProperty("banners")
    private BannersBean banners;

    public BannersBean getBanners() {
        return banners;
    }

    public void setBanners(BannersBean banners) {
        this.banners = banners;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }
}
