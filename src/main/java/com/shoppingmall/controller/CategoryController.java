package com.shoppingmall.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.service.CategoryService;
import com.shoppingmall.vo.CategoryVO;

@Controller
public class CategoryController {
	
	@Inject
	private CategoryService service;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String Category(Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = service.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		return "/category";
	}
}
