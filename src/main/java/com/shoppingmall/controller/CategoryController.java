package com.shoppingmall.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.service.CategoryService;
import com.shoppingmall.vo.CategoryVO;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Inject
	CategoryService categoryService;
	
	//카테고리 관리 페이지
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String management(Locale locale, Model model) throws Exception {
		
		List<CategoryVO> result = categoryService.getCategoryList();
		
		model.addAttribute("result",result);
		
		return "/Category";
	}
}
