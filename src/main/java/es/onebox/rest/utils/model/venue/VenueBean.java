package es.onebox.rest.utils.model.venue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.onebox.rest.utils.model.location.LocationBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlAttribute(name="name")
    @JsonProperty("@name")
    private String name;

    @XmlAttribute(name="timeZone")
    @JsonProperty("@timeZone")
    private String timeZone;

    @XmlElement(name="location")
    @JsonProperty("location")
    private LocationBean location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }
}
