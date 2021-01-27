package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> GetReply(Integer b_num) throws Exception;
	public void WroteReply(ReplyVO vo) throws Exception;
	public void UpdateReply(ReplyVO vo) throws Exception;
	public void DeleteReply(Integer replynum) throws Exception;
	public int DeleteNotice(Integer replynum) throws Exception;
}
