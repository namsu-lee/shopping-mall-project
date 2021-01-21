package com.shoppingmall.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

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
	
	private static List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		//접속자 수, 접속자 아이디 가져온다.
		int num = AccessorVO.getHttpSession().size();
		List<String> NickList = new ArrayList<String>();
		for(int i = 0; i < AccessorVO.getHttpSession().size(); i++) {
			String memberid = (String) AccessorVO.getHttpSession().get(i).getAttribute("memberid");
			//list.add(registerService.ListNameAccessor(memberid).get(i));
			
			
			Map<String, String> map = registerService.ListNameAccessor(memberid).get(i);
			
			Set<Map.Entry<String, String>> entrySet = map.entrySet();
			
			Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
			
			while(entryIterator.hasNext()) {
				Map.Entry<String, String> entry = entryIterator.next();
				NickList.add(entry.getValue());
			}
		}
		//ListNickName
		
		System.out.println("현재 접속자 수 :: " + AccessorVO.getHttpSession().size());
		for(int i = 0; i < NickList.size(); i++) {
			System.out.println(NickList.get(i));
		}
		
		model.addAttribute("size", AccessorVO.getHttpSession().size());
		model.addAttribute("list", NickList);
		
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
