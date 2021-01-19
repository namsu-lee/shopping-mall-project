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
	
	BoardVO boardvo = new BoardVO();
	
	private static final String Namespace = "com.shoppingmall.mapper.BoardMapper";
	
	public List<BoardVO> GetBoardList(int cateid) throws Exception{
		System.out.println(cateid+"DAO");
		System.out.println(boardvo.toString());
		return sqlSession.selectList(Namespace + ".GetBoardList");
	}
}
