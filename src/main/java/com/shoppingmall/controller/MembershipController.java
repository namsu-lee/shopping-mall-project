package com.shoppingmall.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.vo.CategoryVO;

@Controller
public class MembershipController {
	
	//불러오기
		@RequestMapping(value = "/Membership", method = RequestMethod.GET)
		public String Category(Locale locale, Model model) throws Exception {
	
			return "/MembershipLevel";
		}
}
