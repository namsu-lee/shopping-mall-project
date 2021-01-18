package com.shoppingmall.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
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

import com.shoppingmall.service.CategoryService;
import com.shoppingmall.vo.CategoryVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private CategoryService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		//���� �����ϸ� ä�� ������ ���� �������ش�.@@@@@@@@@@@@
		
		String check = request.getHeader("cookie");
		Cookie cookies[] = null;
		if(check != null)	{
			cookies =request.getCookies();
		}
				
		List<CategoryVO> selectList = service.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		// for(int i = 0; i < cookies.length; i++) {
		// 	if(cookies[i].getName().equals("Auto_Login")) {
		// 		HttpSession session = request.getSession(true);
		// 		session.setAttribute("memberid", cookies[i].getValue());
		// 	}
		// }

		return "/main";
	}
	
}
