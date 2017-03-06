package es.onebox.rest.utils.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan("es.onebox.rest.utils.Validators")
public class HomeController {

	@RequestMapping(path="/", method = RequestMethod.GET)
    public String getAutenticationForm(HttpServletRequest request,Model model) {
		return "home";
	}
	
	@RequestMapping(path="/restClientHome", method = RequestMethod.GET)
    public String getAutenticationForm2(HttpServletRequest request,Model model) {
		return "home";
	}
	
	
	
}
