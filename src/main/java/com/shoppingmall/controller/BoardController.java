package com.shoppingmall.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	//게시판 조회
		@RequestMapping(value = "/board/{cateid}", method = RequestMethod.GET)
		public String MoveBoard(Locale locale, Model model) throws Exception {
			
			
			
			return "/board";
		}
}
