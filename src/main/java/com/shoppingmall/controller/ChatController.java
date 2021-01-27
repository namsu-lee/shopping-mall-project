package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.service.ChatService;
import com.shoppingmall.vo.ChattingBangVO;


@Controller
public class ChatController {

	@Inject
	ChatService chatService;
	
	//채팅방 목록 페이지로 이동
	@RequestMapping(value = "/ChattingBangList", method = RequestMethod.GET)
	public String ChattingBangList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String memberid = (String)session.getAttribute("memberid");
		
		System.out.println("memberid == " + memberid);
		
		//로그인 한 사람의 회원 등급을 가져온다.
		Map<String, String> map = chatService.getMemberShipflag(memberid);
		System.out.println("membershipflag == " + map.get("membershipflag"));
		
		//채팅방 목록 뿌려준다
		List<ChattingBangVO> list = chatService.getChattingBang();
		
		if(list.size() == 0) {
			System.out.println("listChat가 null 입니다......");
		}
		model.addAttribute("membershipflag", map.get("membershipflag"));
		model.addAttribute("list", list);
		return "/ChattingBangList";
	}
	
	//채팅방으로 이동
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String Chat(HttpServletRequest request, HttpServletResponse response) {
		
		return "/chat";
	}
	
	//중복된 채팅방이 있는지 검사
	@ResponseBody
	@RequestMapping(value = "/MakeChattingBang", method = RequestMethod.POST)
	public Map<String, Integer> MakeChattingBang(String title) throws Exception {
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		//0이면 채팅방 생성가능 1이면 불가능
		int num = chatService.CheckChattingBang(title);
		if(num == 1) {
			map.put("num", 1);
		}
		else if(num == 0) {
			chatService.MakeChattingBang(title);
			map.put("num", 0);
		}
		return map;
	}
	
	
	//채팅방 삭제
	@ResponseBody
	@RequestMapping(value = "/chattitleremove", method = RequestMethod.POST)
	public Map<String, Integer> ChatTitleRemove(ChattingBangVO vo) throws Exception {
		
		System.out.println(" vo == " + vo.getTitle());

		//채팅방 삭제
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", chatService.ChatTitleRemove(vo.getTitle()));
		return map;
	}
	
	
	
	
	
	
}