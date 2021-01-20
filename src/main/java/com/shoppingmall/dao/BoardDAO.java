package com.shoppingmall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.BoardVO;

@Repository
public class BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	
	private static final String Namespace = "com.shoppingmall.mapper.BoardMapper";
	
	public List<BoardVO> GetBoardList(Integer cateid) throws Exception{
		return sqlSession.selectList(Namespace + ".GetBoardList", cateid);
	}
	public List<BoardVO> ViewBoard(Integer b_num) throws Exception{
		return sqlSession.selectList(Namespace + ".ViewBoard", b_num);
	}
}
