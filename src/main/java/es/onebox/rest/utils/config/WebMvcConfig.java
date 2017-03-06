package es.onebox.rest.utils.config;

import es.onebox.rest.utils.interceptors.AutenticationInterceptor;
import es.onebox.rest.utils.interceptors.HeaderTabInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application configuration class
 *
 * @author Oreste Luci
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * Adding url mappings
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        if (Constants.embeded.booleanValue() == true) {
            registry.addViewController("/restClientHome").setViewName("home");
        } else {
            registry.addViewController("/").setViewName("home");
        }
    }

    /**
     * Adding request interceptors.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // For intercepting URLs and check if the authentication has been performed
        registry.addInterceptor(new AutenticationInterceptor()).addPathPatterns("/query","/query/*");

        // Interceptor to set the appropriate selected tab in the nav bar
        registry.addInterceptor(new HeaderTabInterceptor());
    }
}
