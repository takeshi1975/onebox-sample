package es.onebox.rest.utils.model.event;

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
public class PromoterBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlElement(name="corporateName")
    @JsonProperty("corporateName")
    private String corporateName;

    @XmlElement(name="fiscalCode")
    @JsonProperty("fiscalCode")
    private String fiscalCode;

    @XmlElement(name="location")
    @JsonProperty("location")
    private LocationBean location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }
}
