package com.shoppingmall.controller;

import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.service.NoticeService;
import com.shoppingmall.service.ReplyService;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.NoticeVO;
import com.shoppingmall.vo.ReplyVO;

@Controller
public class ReplyController {
	@Inject
	private ReplyService reply;
	
	@Inject
	NoticeService noticeService;
	
	//댓글 작성
	@RequestMapping(value = "/board/{cateid}/{b_num}/wrotereply")
	public String WroteReply(@PathVariable Integer cateid, @PathVariable Integer b_num, ReplyVO vo, Locale locale, Model model) throws Exception {

		reply.WroteReply(vo);
		
		
		BoardVO boardVO = new BoardVO();
		boardVO.setCateid(cateid);
		boardVO.setB_num(b_num);
		
		//게시글은 쓴 사람의 아이디 구해야 한다.
		Map<String, String> map = noticeService.getBoardMemberid(boardVO);
		System.out.println("게시글은 쓴 사람의 아이디 == " + map.get("memberid"));
		//방금 작성한 댓글 번호를 가져옴
		//int num = noticeService.getReplyNo();
		//System.out.println("방금 작성한 댓글 번호 == " + num);
		
		
		//알람 로직
		//가지고 올것 -> b_num : 게시글 번호, 댓글 번호
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setCateid(cateid); 			//카테고리 아이디
		noticeVO.setBoard_no(b_num);			//게시글 번호
		noticeVO.setReply_no(vo.getReplynum());//댓글 번호
		noticeVO.setMemberid(map.get("memberid"));		//게시글을 쓴 사람의 id(알람 받을 사람)
		noticeVO.setAnother_memberid(vo.getMemberid());//댓글을 쓴 사람의 아이디
		
		
		
		//notice 테이블에 저장 (확인차 찍어봅니다......)
		int result = noticeService.NoticeList(noticeVO);
		if(result == 1) {
			System.out.println("잘 저장이 되었다.");
		}
		else {
			System.out.println("잘 저장이 안되었다.@@@@@@");
		}
		
		
		
		
		return "redirect:/board/{cateid}/{b_num}";
	}
	//댓글 수정
	@RequestMapping(value = "/board/{cateid}/{b_num}/{replynum}/updatedreply")
	public String UpdatedReply(@PathVariable Integer replynum, @PathVariable Integer b_num, @PathVariable Integer cateid, ReplyVO vo, Locale locale, Model model) throws Exception {
		
		reply.UpdateReply(vo);
		
		return "redirect:/board/{cateid}/{b_num}";
	}
	
	//댓글 삭제
	
	@RequestMapping(value = "/board/{cateid}/{b_num}/{replynum}/deletereply")
	public String DeleteReply(@PathVariable Integer replynum, @PathVariable Integer b_num, @PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		reply.DeleteReply(replynum);
		
		return "redirect:/board/{cateid}/{b_num}";
	}
	
}
