package com.shoppingmall.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
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
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.AccessorVO;
import com.shoppingmall.vo.CategoryVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private CategoryService service;
	
	@Inject
	private RegisterService registerService;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		//접속자 수, 접속자 아이디 가져온다.
		int num = AccessorVO.getHttpSession().size();
		for(int i = 0; i < AccessorVO.getHttpSession().size(); i++) {
			String memberid = (String) AccessorVO.getHttpSession().get(i).getAttribute("memberid");
			list = registerService.ListNameAccessor(memberid); //서비스 부터 시작
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		model.addAttribute("list", list);
		
		//게시판 목록 불러오기
		List<CategoryVO> selectList = service.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		//쿠키 가져오기
		String check = request.getHeader("cookie");
		Cookie cookies[] = null;
		
		if(check != null)	{
			cookies =request.getCookies();
		}
		
		if(cookies == null) {
			return "/main";
		}
		
		//로그인 정보 가져오기
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("Auto_Login")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("memberid", cookies[i].getValue());
			}
		}

		return "/main";
	}
	
}
