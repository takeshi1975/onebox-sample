package es.onebox.rest.utils.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.onebox.rest.utils.model.communication.CommunicationElementsBean;
import es.onebox.rest.utils.model.dates.DatesBean;
import es.onebox.rest.utils.model.languages.LanguagesBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Oreste Luci
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventBasicInfoBean {

    @XmlAttribute(name="id")
    @JsonProperty("@id")
    private Integer id;

    @XmlElement(name="externalReferenceCode")
    @JsonProperty("externalReferenceCode")
    private String externalReferenceCode;

    @XmlElement(name="title")
    @JsonProperty("title")
    private String title;

    @XmlElement(name="subtitle")
    @JsonProperty("subtitle")
    private String subtitle;

    @XmlElement(name="shortDescription")
    @JsonProperty("shortDescription")
    private String shortDescription;

    @XmlElement(name="longDescription")
    @JsonProperty("longDescription")
    private String longDescription;

    @XmlElement(name="severalVenues")
    @JsonProperty("severalVenues")
    private Boolean severalVenues;

    @XmlElement(name="severalLocations")
    @JsonProperty("severalLocations")
    private Boolean severalLocations;

    @XmlElement(name="supraEvent")
    @JsonProperty("supraEvent")
    private Boolean supraEvent;

    @XmlElement(name="giftTicket")
    @JsonProperty("giftTicket")
    private Boolean giftTicket;

    @XmlElement(name="eventType")
    @JsonProperty("eventType")
    private String eventType;

    @XmlElement(name="communication-elements",namespace="http://www.oneboxtm.es/ns/communication")
    @JsonProperty("communication-elements")
    private CommunicationElementsBean communicationElements;

    @XmlElement(name="taxonomy")
    @JsonProperty("taxonomy")
    private TaxonomyBean taxonomy;

    @XmlElement(name="languages")
    @JsonProperty("languages")
    private LanguagesBean languages;

    @XmlElement(name="dates")
    @JsonProperty("dates")
    private DatesBean dates;

    @XmlElement(name="entidad")
    @JsonProperty("entidad")
    private EntityBean entity;

    @XmlElement(name="promotor")
    @JsonProperty("promotor")
    private PromoterBean promoter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Boolean getSeveralVenues() {
        return severalVenues;
    }

    public void setSeveralVenues(Boolean severalVenues) {
        this.severalVenues = severalVenues;
    }

    public Boolean getSeveralLocations() {
        return severalLocations;
    }

    public void setSeveralLocations(Boolean severalLocations) {
        this.severalLocations = severalLocations;
    }

    public Boolean getSupraEvent() {
        return supraEvent;
    }

    public void setSupraEvent(Boolean supraEvent) {
        this.supraEvent = supraEvent;
    }

    public Boolean getGiftTicket() {
        return giftTicket;
    }

    public void setGiftTicket(Boolean giftTicket) {
        this.giftTicket = giftTicket;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public CommunicationElementsBean getCommunicationElements() {
        return communicationElements;
    }

    public void setCommunicationElements(CommunicationElementsBean communicationElements) {
        this.communicationElements = communicationElements;
    }

    public TaxonomyBean getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(TaxonomyBean taxonomy) {
        this.taxonomy = taxonomy;
    }

    public LanguagesBean getLanguages() {
        return languages;
    }

    public void setLanguages(LanguagesBean languages) {
        this.languages = languages;
    }

    public DatesBean getDates() {
        return dates;
    }

    public void setDates(DatesBean dates) {
        this.dates = dates;
    }

    public EntityBean getEntity() {
        return entity;
    }

    public void setEntity(EntityBean entity) {
        this.entity = entity;
    }

    public PromoterBean getPromoter() {
        return promoter;
    }

    public void setPromoter(PromoterBean promoter) {
        this.promoter = promoter;
    }
}
