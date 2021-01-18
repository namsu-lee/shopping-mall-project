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
	
	//불러오기
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String Category(Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = service.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		return "/category";
	}
	
	//입력하기
	@RequestMapping(value = "/category/insert", method = RequestMethod.POST)
	public String InsertCategory(Locale locale, Model model, CategoryVO vo) throws Exception {
		
		System.out.println(vo.toString());
		
		service.CategoryInsert(vo);
		
//		List<CategoryVO> selectList = service.CategoryGet();
//		model.addAttribute("selectList", selectList);
		
		return "redirect:/category";
	}
	
//	//수정하기
//	@RequestMapping(value = "/category/update", method = RequestMethod.GET)
//	public String UpdateCategory(Locale locale, Model model) throws Exception {
//		
//		List<CategoryVO> selectList = service.CategoryGet();
//		model.addAttribute("selectList", selectList);
//		
//		return "/category";
//	}
//	
//	//삭제하기
//	@RequestMapping(value = "/category/delete", method = RequestMethod.GET)
//	public String DeleteCategory(Locale locale, Model model) throws Exception {
//		
//		List<CategoryVO> selectList = service.CategoryGet();
//		model.addAttribute("selectList", selectList);
//		
//		return "/category";
//	}
}
