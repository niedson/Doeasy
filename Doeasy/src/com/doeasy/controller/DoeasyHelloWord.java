package com.doeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoeasyHelloWord {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWord() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Welcome Page</h3></div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}	

}
