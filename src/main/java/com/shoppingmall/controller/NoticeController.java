package com.shoppingmall.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.service.NoticeService;
import com.shoppingmall.vo.NoticeVO;

@Controller
public class NoticeController {

	@Inject
	NoticeService noticeService; 
	
	//알람 창으로 이동
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model, HttpSession session) throws Exception {
		
		//알람 뿌려주는 로직
		
		String memberid = (String)session.getAttribute("memberid");
		
		//알람 리스트 가져오기
		List<NoticeVO> list = noticeService.getListNotice(memberid);
		
		//확인차 찍어봅니다.......
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		model.addAttribute("list", list);
		return "/notice";
	}
}
