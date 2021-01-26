package com.shoppingmall.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import com.shoppingmall.service.MainService;
import com.shoppingmall.service.NoticeService;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.VisitcountService;
import com.shoppingmall.vo.AccessorVO;
import com.shoppingmall.vo.CategoryVO;
import com.shoppingmall.vo.MainVO;
import com.shoppingmall.vo.MembersVO;


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
	
	@Inject
	VisitcountService visitcountService;
	
	@Inject
	private MainService mainService;
	
	@Inject
	private NoticeService noticeService;
	 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) throws Exception {
		List<String> list = new ArrayList<String>();
		
		HttpSession session = request.getSession(true);
		String SessionID = (String)session.getAttribute("memberid");
		
		//읽지 않은 알람의 개수를 구해옴
		int read_count = noticeService.getReadCount(SessionID);
		System.out.println("read_count == " + read_count);
		
		//접속자 수, 접속자 아이디 가져온다.
		int num = AccessorVO.getHttpSession().size();
		for(int i = 0; i < AccessorVO.getHttpSession().size(); i++) {
			String memberid = (String) AccessorVO.getHttpSession().get(i).getAttribute("memberid");
			MembersVO vo = registerService.ListNameAccessor(memberid);
			list.add(vo.getNickname());
		}
		System.out.println("list 크기 == " + list.size());
		
		System.out.println("현재 접속자 수 :: " + AccessorVO.getHttpSession().size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		
		model.addAttribute("list", list); //접속자 아이디
		model.addAttribute("size", AccessorVO.getHttpSession().size()); //접속자 수
		model.addAttribute("TotalCount", visitcountService.getTotalCount().getTotalcount());//총 방문자 수
		model.addAttribute("TodayCount", visitcountService.getTodayCount());//오늘 방문자 수
		
		
		model.addAttribute("read_count", read_count);
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
				session.setAttribute("memberid", cookies[i].getValue());
			}
		}
		
		//메인 불러오기
		MainVO UpdateGetMain = mainService.UpdateGetMain();
		model.addAttribute("UpdateGetMain", UpdateGetMain);
		
		
		return "/main";
	}
	
	//메인 수정 페이지
	@RequestMapping(value = "/mainupdate")
	public String UpdateGetMain(Locale locale, Model model) throws Exception {
		//게시판 목록 불러오기
		List<CategoryVO> selectList = service.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		//메인 불러오기
		MainVO UpdateGetMain = mainService.UpdateGetMain();
		model.addAttribute("UpdateGetMain", UpdateGetMain);
		
		return "/mainupdate";
	}
	
	//메인 수정 로직
	@RequestMapping(value = "/mainupdated")
	public String UpdatedMain(MainVO vo, Locale locale, Model model) throws Exception {
		
		mainService.UpdateMain(vo);
		
		return "redirect:/";
	}
}
