package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.service.NoticeService;
import com.shoppingmall.service.ReplyService;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.NoticeVO;
import com.shoppingmall.vo.ReplyVO;

@RestController
public class ReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private ReplyService reply;
	
	@Inject
	NoticeService noticeService;
	
	//댓글 불러오기
	@RequestMapping(value = "/GetReply")
	public List<ReplyVO> GetReply(int b_num) throws Exception {
		return reply.GetReply(b_num);
	}
	
	//댓글 작성
	@RequestMapping(value = "/wrotereply")
	public Map<String, Object> WroteReply(Integer cateid, Integer b_num, @RequestBody ReplyVO vo, 
		Locale locale, Model model) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		
		try {
		reply.WroteReply(vo);
		result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		
		BoardVO boardVO = new BoardVO();
		boardVO.setCateid(cateid);
		boardVO.setB_num(b_num);
		
		System.out.println(boardVO.getCateid());
		System.out.println(boardVO.getB_num());
		
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
		int result1 = noticeService.NoticeList(noticeVO);
		if(result1 == 1) {
			System.out.println("잘 저장이 되었다.");
		}
		else {
			System.out.println("잘 저장이 안되었다.@@@@@@");
		}
		
		return result;
	}
	
	//댓글 수정
	@RequestMapping(value = "/updatedreply")
	public Map<String, Object> UpdatedReply(@RequestBody ReplyVO vo, Locale locale, Model model) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			reply.UpdateReply(vo);
		result.put("status", "OK");
		} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "False");
		}
		return result;
	}
	
	//댓글 삭제
	@RequestMapping(value = "/deletereply")
	@ResponseBody
	public Map<String, Object> DeleteReply( Integer replynum, Locale locale, Model model) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			reply.DeleteNotice(replynum);
			reply.DeleteReply(replynum);
			result.put("status", "OK");
	
			} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
			}
			return result;
	}
	
}
