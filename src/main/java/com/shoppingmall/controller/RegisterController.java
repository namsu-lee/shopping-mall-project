package com.shoppingmall.controller;

//한글 실험
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.VisitcountService;
import com.shoppingmall.vo.AccessorVO;
import com.shoppingmall.vo.MembersVO;

@Controller
@RequestMapping(value = "/signup")
public class RegisterController {

	@Inject
	RegisterService registerService;

	@Inject
	JavaMailSender mailSender;

	@Inject
	VisitcountService visitcountService;
	
	//회원가입 페이지로 이동
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) throws Exception {

		return "/register";
	}


	//아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public Map<String, Integer> CheckID(Locale locale, Model model, String id) throws Exception {
		
		int num = registerService.CheckID(id);
		System.out.println(num);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		System.out.println("여기 탄다.");
		return map;
	}
	
	//닉네임 중복확인
	@ResponseBody
	@RequestMapping(value = "/nicknamecheck", method = RequestMethod.POST)
	public Map<String, Integer> CheckNickName(String nickname) throws Exception {
		
		System.out.println("nickname == " + nickname);
		
		int num = registerService.CheckNickName(nickname);
		System.out.println(num);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);

		return map;
		
	}

	// 이메일 인증
	@ResponseBody
	@RequestMapping(value = "/emailcheck", method = RequestMethod.POST)
	public Map<String, String> CheckEmail(String email, MembersVO membersVO) throws Exception {

		String num = membersVO.Random_Number(); //
		String setfrom = "gudxo12261@gmail.com";
		String tomail = email;
		String title = "man게시판 이메일 인증번호가 왔어요~";
		String content = "<img src=\"cid:man.jpg\" style='width:300px; height:100px;'>"
				+ "<br/><h1>man쇼핑몰을 찾아주셔서 감사합니다.</h1><br/>" + "<h2>인증번호는 <font color='pink'>" + num
				+ "</font>니다.</h2>";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); 
			messageHelper.setTo(tomail); 
			messageHelper.setSubject(title); 
			messageHelper.setText(content, true); 

			FileSystemResource file = new FileSystemResource(new File("C:/man.jpg"));
			messageHelper.addInline("man.jpg", file);
			mailSender.send(message);

			Map<String, String> map = new HashMap<String, String>();
			map.put("num", num);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CheckEmail() 오류");
			return null;
		}
	}

	//회원가입
	@RequestMapping(value = "/registerok", method = RequestMethod.POST)
	public String RegisterOk(MembersVO membersVO, HttpServletRequest request) throws Exception {

		System.out.println(membersVO.toString());

		//비밀번호 암호화
		membersVO.setPassword(MembersVO.bytesToHex2(MembersVO.sha256(membersVO.getPassword())));

		int result = registerService.Register(membersVO);
		if (result == 1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("memberid", membersVO.getMemberid());
			
			//접속자의 session을 리스트에 추가
			AccessorVO.getHttpSession().add(session);
			System.out.println("현재 접속자 수 :: " + AccessorVO.getHttpSession().size());
		
			//총 방문자 수 +1 , 오늘 방문자 수 +1
			visitcountService.UpdateTodayCount(membersVO.getMemberid()); 
			visitcountService.UpdateTotalCount();
		}
		return "redirect:/";
	}
}
