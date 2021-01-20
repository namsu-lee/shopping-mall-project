package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.client.Client;
import com.shoppingmall.task.TransmissionControlProtocol;


@Controller
public class ChatController {

	@RequestMapping(value = "/ChattingBangList", method = RequestMethod.GET)
	public String ChattingBangList(HttpServletRequest request, HttpServletResponse response) {
		
		return "/ChattingBangList";
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String Chat(HttpServletRequest request, HttpServletResponse response) {
		
		return "/chat";
	}
}