package es.onebox.rest.utils.model.communication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oreste Luci
 */
@XmlRootElement(name="banners",namespace="http://www.oneboxtm.es/ns/communication")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BannersBean {

    @XmlElement(name="banner")
    private List<BannerBean> banners;

    /**
     * Adding separate property for JSON since the Json and XML structures are different.
     */
    @JsonProperty("banner")
    private BannerBean banner;

    public BannerBean getBanner() {
        return banner;
    }

    public void setBanner(BannerBean banner) {
        this.banner = banner;
        banners = new ArrayList<>(1);
        banners.add(this.banner);
    }

    public List<BannerBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerBean> banners) {
        this.banners = banners;
    }
}
