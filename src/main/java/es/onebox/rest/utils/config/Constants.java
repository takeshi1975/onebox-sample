package es.onebox.rest.utils.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Oreste Luci
 */
@Component
public class Constants {

    public static Boolean embeded;

    @Autowired
    public Constants(@Value("${rest-client.embeded:false}") String embeded) {

        if ("true".equalsIgnoreCase(embeded)) {
            this.embeded = new Boolean(true);
        } else {
            this.embeded = new Boolean(false);
        }
    }

}
