package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.ReplyDAO;
import com.shoppingmall.service.ReplyService;
import com.shoppingmall.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDAO ReplyDAO;
	
	@Override
	public List<ReplyVO> GetReply(Integer b_num) throws Exception{
		
		return ReplyDAO.GetReply(b_num);
	}
	
	@Override
	public void WroteReply(ReplyVO vo) throws Exception{
		ReplyDAO.WroteReply(vo);
	}
	
	@Override
	public void UpdateReply(ReplyVO vo) throws Exception{
		ReplyDAO.UpdateReply(vo);
	}
	
	@Override
	public void DeleteReply(Integer replynum) throws Exception{
		ReplyDAO.DeleteReply(replynum);
	}
}
