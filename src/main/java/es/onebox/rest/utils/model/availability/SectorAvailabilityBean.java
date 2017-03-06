package es.onebox.rest.utils.model.availability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectorAvailabilityBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlElement(name="availability-info")
    @JsonProperty("availability-info")
    private AvailabilityInfoBean availabilityInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AvailabilityInfoBean getAvailabilityInfo() {
        return availabilityInfo;
    }

    public void setAvailabilityInfo(AvailabilityInfoBean availabilityInfo) {
        this.availabilityInfo = availabilityInfo;
    }
}
