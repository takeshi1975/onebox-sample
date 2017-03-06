package es.onebox.rest.utils.model.dates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="datetime",namespace="http://www.oneboxtm.es/ns/dates")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateTimeBean {

    @XmlAttribute(name="type")
    @JsonProperty("@type")
    private String type;

    @XmlAttribute(name="timeZoneId")
    @JsonProperty("@timeZoneId")
    private String timeZoneId;

    @XmlValue
    @JsonProperty("$")
    private Date datetime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
