package es.onebox.rest.utils.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.onebox.rest.utils.service.QueryService;
import es.onebox.rest.utils.utils.ResponseErrorCodesEnum;

/**
 * @author Oreste Luci
 */
@Controller
@ComponentScan("es.onebox.rest.utils.service")
@RequestMapping("/error-codes")
public class ErrorCodesController {

    public static final Logger logger = LoggerFactory.getLogger(ErrorCodesController.class);

    @Autowired
    private QueryService queryService;

    @RequestMapping("/data")
    public String getInfo(){
    	return "index";
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(HttpServletRequest request, Model model) {

        model.addAttribute("error_codes", ResponseErrorCodesEnum.values());
        return "error_codes";
    }
}
