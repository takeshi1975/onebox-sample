package es.onebox.rest.utils.model.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.onebox.rest.utils.model.availability.AvailabilityInfoBean;
import es.onebox.rest.utils.model.dates.DatesBean;
import es.onebox.rest.utils.model.event.EventBasicInfoBean;
import es.onebox.rest.utils.model.prices.PriceZonesAvailabilityBean;
import es.onebox.rest.utils.model.venue.SpaceBean;
import es.onebox.rest.utils.model.venue.VenueBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionSearchInfoBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlAttribute(name="rates")
    @JsonProperty("@rates")
    private String rates;

    @XmlElement(name="internalName")
    @JsonProperty("internalName")
    private String internalName;

    @XmlElement(name="name")
    @JsonProperty("name")
    private String name;

    @XmlElement(name="description")
    @JsonProperty("description")
    private String description;

    @XmlElement(name="dates")
    @JsonProperty("dates")
    private DatesBean dates;

    @XmlElement(name="venue")
    @JsonProperty("venue")
    private VenueBean venue;

    @XmlElement(name="space")
    @JsonProperty("space")
    private SpaceBean space;

    @XmlElement(name="event-basic-info")
    @JsonProperty("event-basic-info")
    private EventBasicInfoBean eventBasicInfo;

    @XmlElement(name="forSale")
    @JsonProperty("forSale")
    private Boolean forSale;

    @XmlElement(name="hasProducts")
    @JsonProperty("hasProducts")
    private Boolean hasProducts;

    @XmlElement(name="admission")
    @JsonProperty("admission")
    private String admission;

    @XmlElement(name="supportedVisitorType")
    @JsonProperty("supportedVisitorType")
    private String supportedVisitorType;

    @XmlElement(name="availability-info")
    @JsonProperty("availability-info")
    private AvailabilityInfoBean availability;

    @XmlElement(name="sessionMinPrice")
    @JsonProperty("sessionMinPrice")
    private PriceBean sessionMinPrice;

    @XmlElement(name="sessionMaxPrice")
    @JsonProperty("sessionMaxPrice")
    private PriceBean sessionMaxPrice;

    @XmlElement(name="price-zones-availability")
    @JsonProperty("price-zones-availability")
    private PriceZonesAvailabilityBean priceZonesAvailability;

    public PriceZonesAvailabilityBean getPriceZonesAvailability() {
        return priceZonesAvailability;
    }

    public void setPriceZonesAvailability(PriceZonesAvailabilityBean priceZonesAvailability) {
        this.priceZonesAvailability = priceZonesAvailability;
    }

    public Boolean getHasProducts() {
        return hasProducts;
    }

    public void setHasProducts(Boolean hasProducts) {
        this.hasProducts = hasProducts;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getSupportedVisitorType() {
        return supportedVisitorType;
    }

    public void setSupportedVisitorType(String supportedVisitorType) {
        this.supportedVisitorType = supportedVisitorType;
    }

    public AvailabilityInfoBean getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityInfoBean availability) {
        this.availability = availability;
    }

    public PriceBean getSessionMinPrice() {
        return sessionMinPrice;
    }

    public void setSessionMinPrice(PriceBean sessionMinPrice) {
        this.sessionMinPrice = sessionMinPrice;
    }

    public PriceBean getSessionMaxPrice() {
        return sessionMaxPrice;
    }

    public void setSessionMaxPrice(PriceBean sessionMaxPrice) {
        this.sessionMaxPrice = sessionMaxPrice;
    }

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public EventBasicInfoBean getEventBasicInfo() {
        return eventBasicInfo;
    }

    public void setEventBasicInfo(EventBasicInfoBean eventBasicInfo) {
        this.eventBasicInfo = eventBasicInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DatesBean getDates() {
        return dates;
    }

    public void setDates(DatesBean dates) {
        this.dates = dates;
    }

    public VenueBean getVenue() {
        return venue;
    }

    public void setVenue(VenueBean venue) {
        this.venue = venue;
    }

    public SpaceBean getSpace() {
        return space;
    }

    public void setSpace(SpaceBean space) {
        this.space = space;
    }
}
