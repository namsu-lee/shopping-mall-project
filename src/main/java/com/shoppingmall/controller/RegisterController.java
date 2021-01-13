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
	
	//ȸ������ �������� �̵�
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) throws Exception {
		
		return "/register";
	}
	
	
	//���̵� �ߺ��˻�
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public Map<String, Integer> CheckID(Locale locale, Model model, String id) throws Exception {
		
		System.out.println("����ڰ� �Է��� ���̵� :: " + id);
		
		int num = registerService.CheckID(id);	//1�� ��ȯ�ϸ� ����ϰ� ����
		System.out.println(num);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return map;
	}
	
	
	//ȸ������ 
	@RequestMapping(value = "/registerok", method = RequestMethod.POST)
	public String RegisterOk() throws Exception {
		
		//member ���̺� ���� �� address ���̺� ����
		
		return null;
	}
}
