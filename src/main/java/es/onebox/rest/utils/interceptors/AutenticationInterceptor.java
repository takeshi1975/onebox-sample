package es.onebox.rest.utils.interceptors;

import es.onebox.rest.utils.model.AuthenticationForm;
import es.onebox.rest.utils.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Intercepts call to determine if authentication parameters has been entered. If not if forwards to authentication page.
 *
 * @author Oreste Luci
 */
@Component
public class AutenticationInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(AutenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("Intercepted: " + request.getRequestURI());

        AuthenticationForm authenticationForm = (AuthenticationForm)request.getSession().getAttribute("authenticationForm");

        if (authenticationForm ==null) {

            logger.info("Redirecting to Authentication Form");

            // Adding error message to be displayed in the view
            request.setAttribute(AppUtils.FLASH_KIND_KEY,"danger");
            request.setAttribute(AppUtils.FLASH_MESSAGE_KEY,AppUtils.getMessage("message.notAuthenticated"));

            RequestDispatcher rd = request.getRequestDispatcher("/authentication");
            rd.forward(request, response);

            return false;

        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
