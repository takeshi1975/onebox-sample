package es.onebox.rest.utils.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="events-search",namespace="http://www.oneboxtm.es/ns/data-query/event")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSearchBean {

    @XmlElement(name="event-search-info")
    @JsonProperty("event-search-info")
    private EventSearchInfoBean eventInfo;

    public EventSearchInfoBean getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventSearchInfoBean eventInfo) {
        this.eventInfo = eventInfo;
    }
}
