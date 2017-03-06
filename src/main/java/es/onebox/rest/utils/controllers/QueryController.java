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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Controller to handle query form requests.
 * It has methods to display the form and to habdle its submition.
 *
 * @author Oreste Luci
 */
@Controller
@RequestMapping("/query")
public class QueryController {

    public static final Logger logger = LoggerFactory.getLogger(QueryController.class);

    /**
     * Service that performs the request to Onebox REST server
     */
    @Autowired
    private QueryService queryService;

    /**
     * Displays the Query Form. If no query form present in the request it places one there.
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(HttpServletRequest request,Model model) {

        HttpSession httpSession = request.getSession();
        QueryForm queryForm = (QueryForm)httpSession.getAttribute("queryForm");

        if (queryForm ==null) {
            model.addAttribute(new QueryForm());
        } else {
            model.addAttribute(queryForm);
        }

        return "query_form";
    }

    /**
     * Handles the query form submition. It validates the parameters and if errors are present it forwards to the query
     * form page displaying error messages.
     *
     * If no validation error uses queryService to send request to Onebos REST API. It places result in request and
     * forwards to the query form page.
     *
     * @param queryForm
     * @param result
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processRequest(@ModelAttribute("queryForm") @Valid QueryForm queryForm,
                                           BindingResult result,
                                           Model model,
                                           HttpServletRequest request) {

        // Has validation errors?
        if (result.hasErrors()) {
            AppUtils.flash(model, "danger", "error.validation");
            return "query_form";
        }

        // Getting/Setting forms from session
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("queryForm", queryForm);
        AuthenticationForm authenticationForm = (AuthenticationForm)httpSession.getAttribute("authenticationForm");

        logger.info(queryForm.toString());

        // Performing resquest to Onebox REST API
        ResponseDTO responseDTO = queryService.query(authenticationForm, queryForm);

        // Adding response object to model so that it can be accessed by view
        model.addAttribute("responseDTO",responseDTO);

        return "query_form";
    }
}
