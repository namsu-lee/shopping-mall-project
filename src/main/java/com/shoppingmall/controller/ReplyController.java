package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.service.NoticeService;
import com.shoppingmall.service.ReplyService;
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
	public Map<String, Object> WroteReply(@RequestBody ReplyVO vo, 
			Locale locale, Model model) throws Exception {
		
		Map<String, Object> result = new HashMap<>();
		
		try {
		reply.WroteReply(vo);
		result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
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
