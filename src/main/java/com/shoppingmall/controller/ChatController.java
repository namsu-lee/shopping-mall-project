package com.shoppingmall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.service.ChatService;


@Controller
public class ChatController {

	@Inject
	ChatService chatService;
	
	//채팅방 목록 페이지로 이동
	@RequestMapping(value = "/ChattingBangList", method = RequestMethod.GET)
	public String ChattingBangList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//채팅방 목록 뿌려준다
		List<Map<String, String>> listChat = chatService.getChattingBang();
		List<String> list = new ArrayList<String>();
		
		if(listChat != null) {
			for(int i = 0; i < listChat.size(); i++) {
				list.add(listChat.get(i).get("title"));
			}
		}
		
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
	
	
	
	
	
	
	
	
	
	
}