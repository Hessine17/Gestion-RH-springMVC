package com.essths.pfe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class LoginController {
	
	@RequestMapping(value="/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
	model.addAttribute("error", "true");
	return "login";
	 
	}
	
	
	@RequestMapping("/login")
	public String login(){
	return "login";
	}
	@RequestMapping("/logout")
		
	public String logout(){
		
		
		return "login";

		}
}