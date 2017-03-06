package es.onebox.rest.utils.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.onebox.rest.utils.model.AuthenticationForm;
import es.onebox.rest.utils.utils.AppUtils;
import es.onebox.rest.utils.validators.AutenticationFormValidator;

/**
 * This is the main controller for handling authentication requests.
 * For showing the authentication form and to receive authentication parameters.
 *
 * @author Oreste Luci
 */
@Controller
@ComponentScan("es.onebox.rest.utils.Validators")
@RequestMapping("/authentication")
public class AutenticationController {

    public static final Logger logger = LoggerFactory.getLogger(AutenticationController.class);

    /**
     * To validate authentication parameters
     */
    @Autowired
    private AutenticationFormValidator autenticationFormValidator;

    @InitBinder
    protected void initSignupBinder(WebDataBinder binder) {
        binder.setValidator(autenticationFormValidator);
    }

    /**
     * Displays the authentication form.
     * If the form is not present in the session it creates a new one and places it there.
     *
     * @param request
     * @param model
     * @return forwards to the authentication view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAutenticationForm(HttpServletRequest request,Model model) {

        HttpSession httpSession = request.getSession();
        AuthenticationForm authenticationForm = (AuthenticationForm)httpSession.getAttribute("authenticationForm");

        if (authenticationForm ==null) {
            model.addAttribute(new AuthenticationForm());
        } else {
            model.addAttribute(authenticationForm);
        }

        return "authentication_form";
    }

    /**
     * Handles the authentication form submition. It validates it and returns to the form view if there are any errors.
     * If no errors it redirects to the query form view.
     *
     * @param authenticationForm
     * @param result
     * @param request
     * @param redirectAttributes
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String processAutenticationForm(@ModelAttribute("authenticationForm") @Valid AuthenticationForm authenticationForm,
                                           BindingResult result,
                                           HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                           Model model) {

        if (result.hasErrors()) {
            AppUtils.flash(model,"danger","error.validation");
            return "authentication_form";
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("authenticationForm", authenticationForm);

        logger.info(authenticationForm.toString());

        AppUtils.flash(redirectAttributes, "success", "message.authenticationSuccess");

        return "redirect:/query";
    }
}
