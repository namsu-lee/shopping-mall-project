package com.shoppingmall.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoppingmall.service.CategoryService;
import com.shoppingmall.vo.CategoryVO;

@Controller
public class CategoryController {
	
	@Inject
	private CategoryService service;
	
	//불러오기
	@RequestMapping(value = "/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String Category(Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = service.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		return "/category";
	}
	
	//입력하기
	@RequestMapping(value = "/category/insert", method = RequestMethod.POST)
	public String InsertCategory(Locale locale, Model model, CategoryVO vo,HttpServletResponse response) throws Exception {
		
		List<CategoryVO> selectList = service.CategoryGet();
		List<CategoryVO> selectSortList = service.CategorySortGet();
		List<CategoryVO> selectNameList = service.CategoryNameGet();

		if(vo.getCatename().equals("") || vo.getCatesort() == 0) {
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('이름과 순서를 입력해주세요.'); location.href='/category'</script>");
			pw.flush();
			
			
			model.addAttribute("selectList", selectList);
			return "/category";
		}
		
		//순서 중복이면 리턴
		for(CategoryVO s : selectSortList) {
			if(vo.getCatesort().equals(s.getCatesort())) {
				PrintWriter pw = response.getWriter();
				pw.println("<script>alert('순서가 중복되면 안됩니다.'); location.href='/category'</script>");
				pw.flush();
				return "/category";
			}
		}
		
		//이름 중복이면 리턴
		for(CategoryVO s : selectNameList) {
			if(s.getCatename().equals(vo.getCatename())) {
				PrintWriter pw = response.getWriter();
				pw.println("<script>alert('이름이 중복되면 안됩니다.'); location.href='/category'</script>");
				pw.flush();
				return "/category";
			}
		}
		
		service.CategoryInsert(vo);
		
		return "redirect:/category";
	}
	
	
	//삭제하기
	@RequestMapping(value = "/category/delete", method = RequestMethod.GET)
	public String DeleteCategory(Locale locale, Model model, @RequestParam("i") int i) throws Exception {
		
		//id 입력값이 없으면 리턴
		if(i==0) {
			List<CategoryVO> selectList = service.CategoryGet();
			model.addAttribute("selectList", selectList);
			return "/category";
		}
		
		service.CategoryDelete(i);
		
		return "redirect:/category";
	}
	
	
}
