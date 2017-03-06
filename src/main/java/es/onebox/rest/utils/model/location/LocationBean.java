package es.onebox.rest.utils.model.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationBean {

    @XmlElement(name="address")
    @JsonProperty("address")
    private String address;

    @XmlElement(name="city")
    @JsonProperty("city")
    private String city;

    @XmlElement(name="postalCode")
    @JsonProperty("postalCode")
    private String postalCode;

    @XmlElement(name="countrySubdivision")
    @JsonProperty("countrySubdivision")
    private CountrySubdivisionBean countrySubdivision;

    @XmlElement(name="country")
    @JsonProperty("country")
    private CountryBean country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CountrySubdivisionBean getCountrySubdivision() {
        return countrySubdivision;
    }

    public void setCountrySubdivision(CountrySubdivisionBean countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
    }

    public CountryBean getCountry() {
        return country;
    }

    public void setCountry(CountryBean country) {
        this.country = country;
    }
}
