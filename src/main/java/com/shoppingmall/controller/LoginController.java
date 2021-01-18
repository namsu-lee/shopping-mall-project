package com.shoppingmall.controller;

import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.shoppingmall.service.LoginService;
import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.MembersVO;
import com.shoppingmall.vo.NaverLoginVO;

@Controller
public class LoginController {
	
	@Inject
	LoginService loginService;
	
	//NAVER 연동
	/* naverLoginVO */
	private NaverLoginVO naverLoginVO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginVO(NaverLoginVO naverLoginVO) {
		this.naverLoginVO = naverLoginVO;
	}
		
	//로그인 페이지로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Locale locale, Model model, HttpSession session) throws Exception {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginVO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginVO.getAuthorizationUrl(session);
		System.out.println("naverAuthUrl : " + naverAuthUrl);
		
		
		model.addAttribute("url", naverAuthUrl);
		
		return "/login";
	}
	
	//로그인 처리
	@RequestMapping(value = "/loginok", method = RequestMethod.POST)
	public String LoginOk(Locale locale, Model model, LoginVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(vo.toString());
		//비밀번호 암호화
		vo.setPassword(MembersVO.bytesToHex2(MembersVO.sha256(vo.getPassword())));
		
		LoginVO result = loginService.Login(vo);
		if(vo.getMemberid().equals(result.getMemberid())) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberid", result.getMemberid());
			session.setMaxInactiveInterval(60*60);
			
			Cookie cookie1 = new Cookie("memberid", vo.getMemberid());	//아이디 저장
			Cookie cookie2 = new Cookie("Auto_Login", vo.getMemberid()); //자동로그인
			
			
			//아이디 저장
			if(vo.getAuto_ID().equals("on")) {
				cookie1.setMaxAge(60*60*24);
				response.addCookie(cookie1);
				System.out.println("쿠키 설정한다.,");
			}
			else {
				System.out.println("쿠키 설정한다.,11111111111111111");
				cookie1.setMaxAge(0);		
				response.addCookie(cookie1);
			}
			
			//자동 로그인
			if(vo.getAuto_Login() != null) {
				cookie2.setMaxAge(60*60*24);
				response.addCookie(cookie2);
			}
			else {
				cookie2.setMaxAge(0);	
				response.addCookie(cookie2);
			}
		}
		//return "redirect:/main"; 리다이엑트는 uri를 탄다.
		return "redirect:/";
	}
	

	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String Logout(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String check = request.getHeader("cookie");
		HttpSession session = request.getSession();
		
		Cookie cookies[] = null;
		String cookie = "";
		
		if(check != null) {
			cookies = request.getCookies();
		}
		
		if((cookies != null) && (cookies.length > 0))	{
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("Auto_Login"))	{
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		session.invalidate();
		//return "redirect:/main";
		return "redirect:/";
	}
	
	//***********************************************************************
	//NAVER 연동
	//네이버 로그인 성공시 callback 호출
	@RequestMapping(value = "/callback/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpServletRequest request) throws IOException, ParseException {
		
		System.out.print("aaaaaaaaaaaaaaa");
		
		HttpSession session = request.getSession(true);
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginVO.getAccessToken(session, code, state);
		System.out.print("bbbbbbbbbbbbbbbbbb");
		
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginVO.getUserProfile(oauthToken); //String형식의 json데이터
		
		
		/** apiResult json 구조
		{"resultcode":"00",
		"message":"success",
		"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		
		//3. 데이터 파싱
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		
		
		//response의 nickname값 파싱
		String id = (String)response_obj.get("id");
		System.out.println(" aaaaaaaaaaaaaaaaaaaaaaaaaaaa    "+ id);
		
		
		//4.파싱 닉네임 세션으로 저장
		session.setAttribute("memberid", id); //세션 생성
		model.addAttribute("result", apiResult);
		
		return "redirect:/";
	}
}
