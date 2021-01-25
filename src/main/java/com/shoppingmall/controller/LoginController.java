package com.shoppingmall.controller;

import java.io.PrintWriter;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.shoppingmall.service.LoginService;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.VisitcountService;
import com.shoppingmall.vo.AccessorVO;
import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.MembersVO;
import com.shoppingmall.vo.NaverLoginVO;

@Controller
public class LoginController {
	
	@Inject
	LoginService loginService;
	
	@Inject
	RegisterService registerService;
	
	@Inject
	VisitcountService visitcountService;
	
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
	public String Login(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginVO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginVO.getAuthorizationUrl(session);
		System.out.println("naverAuthUrl : " + naverAuthUrl);
		model.addAttribute("url", naverAuthUrl);
		
		
		String cookie = "";
		String check = request.getHeader("cookie");
		
		Cookie cookies[] = null;
		if(check != null) {
			cookies = request.getCookies();
		}
		
		if((cookies != null) && (cookies.length > 0)) {
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("memberid")) {
					cookie = cookies[i].getValue();
				}
			}
		}
		else {
			cookie = "";
		}
		model.addAttribute("Auto_ID", cookie);
		return "/login";
	}
	
	//로그인 처리
	@RequestMapping(value = "/loginok", method = RequestMethod.POST)
	public String LoginOk(Locale locale, Model model, LoginVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(vo.toString());
		PrintWriter out = response.getWriter();
		
		//비밀번호 암호화
		vo.setPassword(MembersVO.bytesToHex2(MembersVO.sha256(vo.getPassword())));
		
		LoginVO result = loginService.Login(vo);
		if(result == null) {
			out.print("<script>");
			out.println("	alert('아이디 또는 비밀번호가 틀립니다.');");
			out.println("	history.back();");
			out.print("</script>");
			return "/login";
		}
		
		if(vo.getMemberid().equals(result.getMemberid())) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberid", result.getMemberid());
			session.setAttribute("nickname", result.getNickname());
			session.setMaxInactiveInterval(60*60);
			
			//접속자의 session을 리스트에 추가
			AccessorVO.getHttpSession().add(session);
			System.out.println("현재 접속자 수 :: " + AccessorVO.getHttpSession().size());

			Cookie cookie1 = new Cookie("memberid", vo.getMemberid());	//아이디 저장
			Cookie cookie2 = new Cookie("Auto_Login", vo.getMemberid()); //자동로그인
			
			
			//아이디 저장
			if(vo.getAuto_ID() == null) {
				System.out.println("쿠키 취소한다.,11111111111111111");
				cookie1.setMaxAge(0);		
				response.addCookie(cookie1);
			}
			else {
				cookie1.setMaxAge(60*60*24);
				response.addCookie(cookie1);
				System.out.println("쿠키 설정한다.,");
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
		
		//총 방문자 수 +1 , 오늘 방문자 수 +1
		if(visitcountService.getTodayUser(vo.getMemberid()) == 0) {
			visitcountService.UpdateTodayCount(vo.getMemberid());
		}
		visitcountService.UpdateTotalCount();
		
		
		//return "redirect:/main"; 리다이엑트는 uri를 탄다.
		return "redirect:/";
	}
	

	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
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
		
		//접속자 session 삭제
		AccessorVO.getHttpSession().remove(session);
		
		session.invalidate();
		//return "redirect:/main";
		System.out.println("로그아웃.........");
		return "redirect:/";
	}
	
	//***********************************************************************
	//NAVER 연동
	//네이버 로그인 성공시 callback 호출
	@RequestMapping(value = "/callback/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpServletRequest request) throws Exception {
		
		
		HttpSession session = request.getSession(true);
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginVO.getAccessToken(session, code, state);
		
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginVO.getUserProfile(oauthToken); //String형식의 json데이터
		
		/** apiResult json 구조
		{"resultcode":"00","message":"success","response":{"id":"89942918","nickname":"\ub0a8\ub290","email":"surplus92@naver.com",
			"mobile":"010-2544-1091","mobile_e164":"+821025441091","name":"\uc774\ub0a8\uc218"}
			
			가져올거 ==> id, nickname, email, mobile, name
		**/
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. 데이터 파싱
		//Top레벨 단계 _response 파싱
		JSONObject response = (JSONObject)jsonObj.get("response");
		
		// 가져와서 db에 naver 로그인 사용자 저장 
		//response의 nickname값 파싱
		MembersVO vo = new MembersVO();
		vo.setMemberid((String)response.get("id"));
		vo.setPassword((String)response.get("id") + (String)response.get("id"));
		vo.setNickname((String)response.get("nickname"));
		vo.setEmail((String)response.get("email"));
		vo.setAddress("##########-##########");
		vo.setPhone((String)response.get("mobile"));
		vo.setMembername((String)response.get("name"));
		
		//이미 디비에 저장되어있나 검사 해주는 로직 짜야한다.
		if(registerService.NaverCheck((String)response.get("id")) == 0) {
			
			int result = registerService.NaverRegister(vo);
			if(result == 1) {
				
				//AccessorVO.list에 해당 사용자의 세션 추가
				session.setAttribute("memberid", (String)response.get("id")); //세션 생성
				
				//총 방문자 수 +1 , 오늘 방문자 수 +1
				if(visitcountService.getTodayUser(vo.getMemberid()) == 0) {
					visitcountService.UpdateTodayCount(vo.getMemberid());
				}
				visitcountService.UpdateTotalCount();
			}
		}
		else {
			//AccessorVO.list에 해당 사용자의 세션 추가
			session.setAttribute("memberid", (String)response.get("id")); //세션 생성
			
			//총 방문자 수 +1 , 오늘 방문자 수 +1
			if(visitcountService.getTodayUser(vo.getMemberid()) == 0) {
				visitcountService.UpdateTodayCount(vo.getMemberid());
				visitcountService.UpdateTotalCount();
			}
		}
		//model.addAttribute("result", apiResult);
		return "redirect:/";
	}
}
