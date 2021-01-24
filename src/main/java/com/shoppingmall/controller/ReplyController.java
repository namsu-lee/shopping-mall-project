package com.shoppingmall.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.service.ReplyService;
import com.shoppingmall.vo.ReplyVO;

@Controller
public class ReplyController {
	@Inject
	private ReplyService reply;
	
	//댓글 불러오기
	
	
	//댓글 작성
	@RequestMapping(value = "/board/{cateid}/{b_num}/wrotereply")
	public String WroteReply(@PathVariable Integer cateid, @PathVariable Integer b_num, ReplyVO vo, Locale locale, Model model) throws Exception {

		reply.WroteReply(vo);
		
		return "redirect:/board/{cateid}/{b_num}";
	}
	//댓글 수정
	@RequestMapping(value = "/board/{cateid}/{b_num}/updatedreply")
	public String UpdatedReply(@PathVariable Integer b_num, @PathVariable Integer cateid, ReplyVO vo, Locale locale, Model model) throws Exception {
		
		reply.UpdateReply(vo);
		
		return "redirect:/board/{cateid}/{b_num}";
	}
	
	//댓글 삭제
	
	@RequestMapping(value = "/board/{cateid}/{b_num}/deletereply")
	public String DeleteReply(@PathVariable Integer replynum, @PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		reply.DeleteReply(replynum);
		
		return "redirect:/board/{cateid}/{b_num}";
	}
	
}
