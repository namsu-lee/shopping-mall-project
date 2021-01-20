package com.shoppingmall.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.service.BoardService;
import com.shoppingmall.vo.BoardVO;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	BoardVO boardvo = new BoardVO();
	
	//게시판 조회
	@RequestMapping(value = "/board/{cateid}", method = RequestMethod.GET)
	public String MoveBoard(@PathVariable int cateid, Locale locale, Model model) throws Exception {
		
		System.out.println(cateid+",controller");
		
		System.out.println(boardvo.toString());
		
		boardvo.setCateid(cateid);
		
		List<BoardVO> GetBoardList = service.GetBoardList(cateid);
		model.addAttribute("GetBoardList", GetBoardList);
		
		return "/board";
	}
}
