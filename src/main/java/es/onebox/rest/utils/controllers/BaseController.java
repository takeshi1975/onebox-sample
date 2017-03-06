package es.onebox.rest.utils.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class BaseController {

	@RequestMapping("/base")
	public String getHello(){
		// devuelve un mensaje de texto
		return "Hola mundo!!";		
	}
	
}
