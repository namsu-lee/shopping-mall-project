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
		
		String num     = membersVO.Random_Number();	//����
		String setfrom = "gudxo12261@gmail.com";
		String tomail  = email; 
		String title   = "EZEN���θ� ȸ������ ������ȣ �Դϴ�.";
		String content = "<img src=\"cid:ezen.jpg\" style='width:300px; height:100px;'>"
									+ "<br/><h1>EZEN���θ��� ã���ּż� �����մϴ�.</h1><br/>"
										+ "<h2>������ȣ�� <font color='pink'>" + num + "</font> �Դϴ�.</h2>";
		
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            messageHelper.setFrom(setfrom); 				// �����»�� �����ϸ� �����۵��� ����
            messageHelper.setTo(tomail);					// �޴»�� �̸���
            messageHelper.setSubject(title); 				// ���������� ������ �����ϴ�
            messageHelper.setText(content, true);			// ���� ����
            
            //C�� �ش� �̹��� ������ ������ ���� �߻�!
            FileSystemResource file = new FileSystemResource(new File("C:/ezen.jpg"));
            messageHelper.addInline("ezen.jpg", file);
            mailSender.send(message); 
            
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
	public String RegisterOk(MembersVO membersVO, AddressVO addressVO, HttpServletRequest request) throws Exception {
		
		System.out.println(membersVO.toString());
		
		//��ȣȭ
		membersVO.setPassword(MembersVO.bytesToHex2(MembersVO.sha256(membersVO.getPassword())));
		
		int result = registerService.Register(membersVO);
		if(result == 1) {
			int num = registerService.Address(addressVO);
			if(num == 1) {
				//��� �ּұ��� ������ �Ǿ����� �׶� ���ǿ� ����� �߰�
				HttpSession session = request.getSession(true);
				session.setAttribute("memberid", membersVO.getMemberid());
			}
		}
		
		return "main";
	}
}
