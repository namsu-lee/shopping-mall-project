package com.shoppingmall.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.service.BoardService;
import com.shoppingmall.service.CategoryService;
import com.shoppingmall.service.ReplyService;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.CategoryVO;
import com.shoppingmall.vo.ReplyVO;


@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	@Inject
	private CategoryService cate;
	@Inject
	private ReplyService reply;
	
	
	//게시판 목록 조회
	@RequestMapping(value = "/board/{cateid}")
	public String MoveBoard(@PathVariable Integer cateid, Integer page, String keyword, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		List<BoardVO> GetBoardList = service.GetBoardList(cateid, page, keyword);
		model.addAttribute("GetBoardList", GetBoardList);
		return "/board";
	}
	
	//게시글 조회
	@RequestMapping(value = "/board/{cateid}/{b_num}")
	public String ViewBoard(@PathVariable Integer cateid, @PathVariable Integer b_num, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		BoardVO ViewBoard = service.ViewBoard(b_num);
		model.addAttribute("ViewBoard", ViewBoard);
		
		List<ReplyVO> GetReply = reply.GetReply(b_num);
		model.addAttribute("GetReply", GetReply);
		
		return "/viewboard";
	}
	
	//게시글 작성페이지로 이동
	@RequestMapping(value = "/board/{cateid}/writeboard")
	public String WriteBoard(@PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		
		return "/writeboard";
	}
	
	//게시글 작성 로직
	@RequestMapping(value = "/board/{cateid}/wroteboard")
	public String WroteBoard(@PathVariable Integer cateid, BoardVO vo, Locale locale, Model model) throws Exception {

		service.WroteBoard(vo);
		
		return "redirect:/board/{cateid}";
	}
	
	//게시글 수정페이지로 이동
	@RequestMapping(value = "/board/{cateid}/{b_num}/updateboard")
	public String UpdateBoard(@PathVariable Integer b_num, @PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		//글내용 불러오기
		BoardVO UpdateGetBoard = service.UpdateGetBoard(b_num);
		
		model.addAttribute("UpdateGetBoard", UpdateGetBoard);
		
		return "/updateboard";
	}
	
	//게시글 수정 로직
	@RequestMapping(value = "/board/{cateid}/{b_num}/updatedboard")
	public String UpdatedBoard(@PathVariable Integer b_num, @PathVariable Integer cateid, BoardVO vo, Locale locale, Model model) throws Exception {
		
		service.UpdateBoard(vo);
		
		return "redirect:/board/{cateid}";
	}
	
	//게시글 삭제
	@RequestMapping(value = "/board/{cateid}/{b_num}/deleteboard")
	public String DeleteBoard(@PathVariable Integer b_num, @PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		service.DeleteBoard(b_num);
		
		return "redirect:/board/{cateid}";
	}
}
