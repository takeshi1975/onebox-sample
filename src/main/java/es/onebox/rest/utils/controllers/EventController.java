package es.onebox.rest.utils.controllers;

import es.onebox.rest.utils.model.AuthenticationForm;
import es.onebox.rest.utils.model.QueryForm;
import es.onebox.rest.utils.model.ResponseDTO;
import es.onebox.rest.utils.service.QueryService;
import es.onebox.rest.utils.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO This controller is not finished. The purpose is to display response in objects. Only for testing
 * @author Oreste Luci
 */
@Controller
@RequestMapping("/event")
public class EventController {

    public static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/{accept}", method = RequestMethod.GET)
    public String searchEvent(@PathVariable("accept") String accept, HttpServletRequest request, Model model) {

        AuthenticationForm authenticationForm = new AuthenticationForm();
        authenticationForm.setUser("");
        authenticationForm.setTerminal("");
        authenticationForm.setChannelId("");
        authenticationForm.setPos("");
        authenticationForm.setLicense("");
        authenticationForm.setPassword("");

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("authenticationForm", authenticationForm);

        QueryForm queryForm = new QueryForm();
        queryForm.setUrl("http://pre.rest2.oneboxtickets.com/onebox-rest2/rest/events/search?cityPromoter=Barcelona");
        queryForm.setMethod("get");
        queryForm.setAccept(accept);
        queryForm.setMapResponse(new Boolean(true));

        httpSession.setAttribute("queryForm", queryForm);

        request.setAttribute("queryForm", queryForm);

        // Performing resquest to Onebox REST API
        ResponseDTO responseDTO = queryService.query(authenticationForm, queryForm);

        // If there was an error in request it displays error message
        if (responseDTO.getError()==null) {
            AppUtils.flash(model, "success", "request.success");
        } else {
            AppUtils.flash(model, "danger", "error.request");
        }

        // Adding response object to model so that it can be accessed by view
        model.addAttribute("responseDTO",responseDTO);

        return "query_form";
    }
}
