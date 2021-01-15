package com.shoppingmall.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
import com.shoppingmall.vo.AddressVO;
import com.shoppingmall.vo.MembersVO;



@Controller
@RequestMapping(value = "/signup")
public class RegisterController {
	
	@Inject
	RegisterService registerService;
	 
	@Inject
	JavaMailSender mailSender;
	
	
	 
	//회원가입 페이지로 이동
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) throws Exception {
		
		return "/register";
	}
	
	
	//아이디 중복검사
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public Map<String, Integer> CheckID(Locale locale, Model model, String id) throws Exception {
		
		System.out.println("사용자가 입력한 아이디 :: " + id);
		
		int num = registerService.CheckID(id);	//1을 반환하면 사용하고 있음
		System.out.println(num);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return map;
	}
	
	
	//이메일 인증
	@ResponseBody
	@RequestMapping(value = "/emailcheck", method = RequestMethod.POST)
	public Map<String, String> CheckEmail(String email, MembersVO membersVO) throws Exception {
		
		String num     = membersVO.Random_Number();	//난수
		String setfrom = "gudxo12261@gmail.com";
		String tomail  = email; 
		String title   = "EZEN쇼핑몰 회원가입 인증번호 입니다.";
		String content = "<img src=\"cid:ezen.jpg\" style='width:300px; height:100px;'>"
									+ "<br/><h1>EZEN쇼핑몰을 찾아주셔서 감사합니다.</h1><br/>"
										+ "<h2>인증번호는 <font color='pink'>" + num + "</font> 입니다.</h2>";
		
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            messageHelper.setFrom(setfrom); 				// 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail);					// 받는사람 이메일
            messageHelper.setSubject(title); 				// 메일제목은 생략이 가능하다
            messageHelper.setText(content, true);			// 메일 내용
            
            //C에 해당 이미지 파일이 없으면 오류 발생!
            FileSystemResource file = new FileSystemResource(new File("C:/ezen.jpg"));
            messageHelper.addInline("ezen.jpg", file);
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
	public String RegisterOk(MembersVO membersVO, AddressVO addressVO, HttpServletRequest request) throws Exception {
		
		System.out.println(membersVO.toString());
		
		//암호화
		membersVO.setPassword(MembersVO.bytesToHex2(MembersVO.sha256(membersVO.getPassword())));
		
		int result = registerService.Register(membersVO);
		if(result == 1) {
			int num = registerService.Address(addressVO);
			if(num == 1) {
				//디비에 주소까지 저장이 되었으면 그때 세션에 사용자 추가
				HttpSession session = request.getSession();
				session.setAttribute("memberid", membersVO.getMemberid());
			}
		}
		
		return "main";
	}
}
