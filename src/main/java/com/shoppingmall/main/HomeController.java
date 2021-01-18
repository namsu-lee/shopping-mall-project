package com.shoppingmall.main;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		//서버 시작하면 채팅 서버도 같이 시작해준다.@@@@@@@@@@@@
		
		String check = request.getHeader("cookie");
		Cookie cookies[] = null;
		if(check != null)	{
			cookies =request.getCookies();
		}
		
		//지울꺼임.
		if(cookies == null) {
			return "redirect:/main";
		}
		
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("Auto_Login")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("memberid", cookies[i].getValue());
			}
		}

		return "/main";
	}
	
}
