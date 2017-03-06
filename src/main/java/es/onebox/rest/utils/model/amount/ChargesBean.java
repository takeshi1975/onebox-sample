package es.onebox.rest.utils.model.amount;

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
public class ChargesBean {

    @XmlElement(name="charge")
    @JsonProperty("charge")
    private List<ChargeBean> charges;

    public List<ChargeBean> getCharges() {
        return charges;
    }

    public void setCharges(List<ChargeBean> charges) {
        this.charges = charges;
    }
}
