package es.onebox.rest.utils.interceptors;

import es.onebox.rest.utils.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * This filter intercepts requests and sets the corresponding active tab as a request object
 *
 * @author Oreste Luci
 */
@Component
public class HeaderTabInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(HeaderTabInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        logger.info("Intercepted: " + request.getRequestURI());

        HashMap<String,String> activeTab = new HashMap();

        String active = "class='active'";

        // Determining which tab should be active
        if (requestURI.equalsIgnoreCase("/authentication")) {
            activeTab.put("authentication",active);
        } else if (requestURI.equalsIgnoreCase("/query")) {
            activeTab.put("query",active);
        } else if (requestURI.equalsIgnoreCase("/error-codes")) {
            activeTab.put("error_codes",active);
        } else {
            activeTab.put("home",active);
        }

        request.setAttribute("embeded",Constants.embeded);

        // Setting active tab object in request to be used by view
        request.setAttribute("activeTab",activeTab);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
