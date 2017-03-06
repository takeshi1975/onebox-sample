package es.onebox.rest.utils.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="event-search-info",namespace="http://www.oneboxtm.es/ns/data-query/event")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxonomyBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlElement(name="code")
    @JsonProperty("code")
    private String code;

    @XmlElement(name="description")
    @JsonProperty("description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
