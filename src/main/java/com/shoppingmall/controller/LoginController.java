package com.shoppingmall.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.service.LoginService;
import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.MembersVO;

@Controller
public class LoginController {
	
	@Inject
	LoginService loginService;
	
	
	//�α���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(Locale locale, Model model, LoginVO vo, HttpServletRequest request) throws Exception {
		
		//��й�ȣ ��ȣȭ
		vo.setPassword(MembersVO.bytesToHex2(MembersVO.sha256(vo.getPassword())));
		
		LoginVO result = loginService.Login(vo);
		if(vo.getMemberid() == result.getMemberid()) {
			HttpSession session = request.getSession();
			session.setAttribute("memberid", result.getMemberid());
		}
		
		return "/main";
	}
	

	//�α׾ƿ�
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String Logout(Locale locale, Model model) throws Exception {
		
		return "/main";
	}
}
