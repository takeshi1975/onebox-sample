package es.onebox.rest.utils.model.prices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceZonesAvailabilityBean {

    @XmlElement(name="price-zone-availability")
    //@JsonProperty("price-zone-availability")
    private List<PriceZoneAvailabilityBean> priceZoneAvailabilities;

    public List<PriceZoneAvailabilityBean> getPriceZoneAvailabilities() {
        return priceZoneAvailabilities;
    }

    public void setPriceZoneAvailabilities(List<PriceZoneAvailabilityBean> priceZoneAvailabilities) {
        this.priceZoneAvailabilities = priceZoneAvailabilities;
    }
}
