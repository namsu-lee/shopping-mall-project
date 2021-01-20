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
import com.shoppingmall.vo.CategoryVO;
import com.shoppingmall.service.CategoryService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	@Inject
	private CategoryService cate;
	
	
	//게시판 조회
	@RequestMapping(value = "/board/{cateid}", method = RequestMethod.GET)
	public String MoveBoard(@PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		List<BoardVO> GetBoardList = service.GetBoardList(cateid);
		model.addAttribute("GetBoardList", GetBoardList);
		
		return "/board";
	}
	
	//게시글 조회
	@RequestMapping(value = "/board/{cateid}/{b_num}", method = RequestMethod.GET)
	public String ViewBoard(@PathVariable Integer b_num, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		List<BoardVO> ViewBoard = service.ViewBoard(b_num);
		model.addAttribute("ViewBoard", ViewBoard);
		
		return "/viewboard";
	}
	
	//게시글 작성페이지로 이동
	@RequestMapping(value = "/board/{cateid}/writeboard", method = RequestMethod.GET)
	public String WriteBoard(@PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		
		return "/writeboard";
	}
}
