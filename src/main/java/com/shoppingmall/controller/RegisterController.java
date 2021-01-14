package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

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
	
	
	//�̸��� ����
	@ResponseBody
	@RequestMapping(value = "/emailcheck", method = RequestMethod.POST)
	public Map<String, String> CheckEmail(String email, MembersVO membersVO) throws Exception {
		
		String num = membersVO.Random_Number();	//����
		String setfrom = "gudxo12261@gmail.com";
		String tomail  = email; 
		String title   = "ȸ������ ������ȣ �Դϴ�.";
		String content = "������ȣ�� " + num + " �Դϴ�.";
		
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
            messageHelper.setTo(tomail); // �޴»�� �̸���
            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
            messageHelper.setText(content); // ���� ����
            
            mailSender.send(message); //����
            
            Map<String, String> map = new HashMap<String, String>();
    		map.put("num", num);
    		return map;
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("CheckEmail() ����");
        	return null;
        }
	}
	
	
	//ȸ������ 
	@RequestMapping(value = "/registerok", method = RequestMethod.POST)
	public String RegisterOk(MembersVO members, AddressVO address) throws Exception {
		System.out.println(members.toString());
		System.out.println(address.toString());
		//member ���̺� ���� �� address ���̺� ����
		
		return null;
	}
}
