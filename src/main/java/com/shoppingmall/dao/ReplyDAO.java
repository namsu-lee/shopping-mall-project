package com.shoppingmall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.ReplyVO;

@Repository
public class ReplyDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.ReplyMapper";
	
	public List<ReplyVO> GetReply(Integer b_num) throws Exception{
		return sqlSession.selectList(Namespace + ".GetReply", b_num);
	}
	
	public void WroteReply(ReplyVO vo) throws Exception{
		sqlSession.insert(Namespace+".WroteReply", vo);
	}
	public void DeleteReply(Integer replynum) throws Exception{
		sqlSession.delete(Namespace + ".DeleteReply", replynum);
	}
	
	public void UpdateReply(ReplyVO vo) throws Exception{
		sqlSession.insert(Namespace + ".UpdateReply", vo);
	}
}
