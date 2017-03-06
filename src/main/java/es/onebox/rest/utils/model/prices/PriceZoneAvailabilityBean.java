package es.onebox.rest.utils.model.prices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.onebox.rest.utils.model.amount.ChargesBean;
import es.onebox.rest.utils.model.availability.AvailabilityInfoBean;
import es.onebox.rest.utils.model.availability.SectorAvailabilityBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceZoneAvailabilityBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlElement(name="originalBasePrice")
    @JsonProperty("originalBasePrice")
    private Double originalBasePrice;

    @XmlElement(name="originalBasePriceCharges")
    @JsonProperty("originalBasePriceCharges")
    private ChargesBean originalBasePriceCharges;

    @XmlElement(name="promotedPrice")
    @JsonProperty("promotedPrice")
    private Double promotedPrice;

    @XmlElement(name="promotedPriceCharges")
    @JsonProperty("promotedPriceCharges")
    private ChargesBean promotedPriceCharges;

    @XmlElement(name="name")
    @JsonProperty("name")
    private String name;

    @XmlElement(name="color")
    @JsonProperty("color")
    private String color;

    @XmlElement(name="availability-info")
    @JsonProperty("availability-info")
    private AvailabilityInfoBean availabilityInfo;

    @XmlElement(name="sector-availability")
    @JsonProperty("sector-availability")
    private SectorAvailabilityBean sectorAvailability;

    public SectorAvailabilityBean getSectorAvailability() {
        return sectorAvailability;
    }

    public void setSectorAvailability(SectorAvailabilityBean sectorAvailability) {
        this.sectorAvailability = sectorAvailability;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOriginalBasePrice() {
        return originalBasePrice;
    }

    public void setOriginalBasePrice(Double originalBasePrice) {
        this.originalBasePrice = originalBasePrice;
    }

    public ChargesBean getOriginalBasePriceCharges() {
        return originalBasePriceCharges;
    }

    public void setOriginalBasePriceCharges(ChargesBean originalBasePriceCharges) {
        this.originalBasePriceCharges = originalBasePriceCharges;
    }

    public Double getPromotedPrice() {
        return promotedPrice;
    }

    public void setPromotedPrice(Double promotedPrice) {
        this.promotedPrice = promotedPrice;
    }

    public ChargesBean getPromotedPriceCharges() {
        return promotedPriceCharges;
    }

    public void setPromotedPriceCharges(ChargesBean promotedPriceCharges) {
        this.promotedPriceCharges = promotedPriceCharges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AvailabilityInfoBean getAvailabilityInfo() {
        return availabilityInfo;
    }

    public void setAvailabilityInfo(AvailabilityInfoBean availabilityInfo) {
        this.availabilityInfo = availabilityInfo;
    }
}
