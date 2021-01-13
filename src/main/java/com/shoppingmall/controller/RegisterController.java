package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.service.RegisterService;

@Controller
@RequestMapping(value = "/signup")
public class RegisterController {
	
	@Inject
	RegisterService registerService;
	
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
	
	
	//회원가입 
	@RequestMapping(value = "/registerok", method = RequestMethod.POST)
	public String RegisterOk() throws Exception {
		
		//member 테이블에 저장 후 address 테이블 저장
		
		return null;
	}
}
