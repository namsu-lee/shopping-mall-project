package com.shoppingmall.main;

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

import com.shoppingmall.server.Server;
import com.shoppingmall.service.CategoryService;
import com.shoppingmall.vo.CategoryVO;
import com.shoppingmall.task.TransmissionControlProtocol;


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
	public String home(Locale locale, Model model, HttpServletRequest request) throws Exception {
		// 1. 서버를 시작하면 채팅 서버도 동시에 열어준다.
		//boolean portCheck = availablePort("192.168.2.100",6000);
		
		Server server = new Server();
		
		
		
		// 서버가 한번 더 열리기 때문에 조건을 걸어준다.
		if(server.getServerSocket() == null) {
			server.startServer(TransmissionControlProtocol.getIp(), TransmissionControlProtocol.getPort());
		}
		else {
			System.out.println("이미 서버소켓이 열려있다.");
		}
		
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
	
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String Chat() {
		
		return "/chat";
	}
	
	
	
}
