package es.onebox.rest.utils.model.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionsSearchInfoBean {

    @XmlElement(name="session-search-info")
    @JsonProperty("session-search-info")
    private List<SessionSearchInfoBean> sessions;

    public List<SessionSearchInfoBean> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionSearchInfoBean> sessions) {
        this.sessions = sessions;
    }
}
