package es.onebox.rest.utils.model.prices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.onebox.rest.utils.model.amount.ChargeBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceChargesBean {

    @XmlElement(name="charge")
    @JsonProperty("charge")
    private List<ChargeBean> charges;

}
