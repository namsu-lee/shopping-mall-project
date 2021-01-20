package com.shoppingmall.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String ChattingBangList(HttpServletRequest request) {
		
		//회원의 정보를 가져온 후 뿌려주는 로직 작성......
		
		return "/mypage";
	}
	
}
