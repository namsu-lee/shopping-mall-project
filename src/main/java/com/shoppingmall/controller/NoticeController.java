package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println("::::1");
		String memberid = (String)session.getAttribute("memberid");
		System.out.println("::::2");
		//알람 리스트 가져오기
		List<NoticeVO> list = noticeService.getListNotice(memberid);
		System.out.println("::::3");
		//확인차 찍어봅니다.......
		if(list != null) {
			System.out.println("::::4");
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		}
		System.out.println("::::5");
		if(list.isEmpty()){
			System.out.println("게시물에 답글이 하나도 안달렸데");
		}
		System.out.println("::::6");
		System.out.println("list == " + list);
		model.addAttribute("list", list);
		return "/notice";
	}
	
	
	//알람 읽음처리
	@ResponseBody
	@RequestMapping(value = "/changereadcheck", method = RequestMethod.POST)
	public Map<String, Integer> ReadCheck_Change(int notice_no) throws Exception {
		
		
		System.out.println(notice_no);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", noticeService.ReadCheck_Change(notice_no));
		
		return map;
	}
	
	//알람 삭제처리
	@ResponseBody
	@RequestMapping(value = "/deletereadcheck", method = RequestMethod.POST)
	public Map<String, Integer> ReadCheck_Delete(int notice_no) throws Exception {
		
		System.out.println(notice_no);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", noticeService.ReadCheck_Delete(notice_no));
		
		return map;
	}
	
}
