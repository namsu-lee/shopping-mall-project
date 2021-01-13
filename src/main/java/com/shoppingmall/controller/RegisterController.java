package com.shoppingmall.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/signup")
public class RegisterController {
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		
		return "/register";
	}
}
