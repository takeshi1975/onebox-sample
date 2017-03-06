package es.onebox.rest.utils.model.communication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="images",namespace="http://www.oneboxtm.es/ns/communication")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesBean {

    @XmlElement(name="image")
    @JsonProperty("image")
    private List<ImageBean> images;

    public List<ImageBean> getImages() {
        return images;
    }

    public void setImages(List<ImageBean> images) {
        this.images = images;
    }
}
