package es.onebox.rest.utils.model.dates;

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
@XmlRootElement(name="dates",namespace="http://www.oneboxtm.es/ns/dates")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatesBean {

    @XmlElement(name="datetime")
    @JsonProperty("datetime")
    private List<DateTimeBean> dates;

    public List<DateTimeBean> getDates() {
        return dates;
    }

    public void setDates(List<DateTimeBean> dates) {
        this.dates = dates;
    }
}
