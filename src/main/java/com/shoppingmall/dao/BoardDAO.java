package com.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.Pagination;

@Repository
public class BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	
	private static final String Namespace = "com.shoppingmall.mapper.BoardMapper";

	public int getBoardListCnt(Integer cateid, String keyword) throws Exception {
		return sqlSession.selectOne(Namespace + ".getBoardListCnt", cateid, keyword);
	}

	public List<BoardVO> GetBoardList(Integer cateid, Integer page, String keyword, int startList, int listSize) throws Exception{
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		 
		data.put("cateid", cateid);
		data.put("keyword", keyword);
		data.put("startList", startList);
		data.put("listSize", listSize);
		
		return sqlSession.selectList(Namespace + ".GetBoardList", data);
	}
	
	public BoardVO ViewBoard(Integer b_num) throws Exception{
		return sqlSession.selectOne(Namespace + ".ViewBoard", b_num);
	}
	
	public void WroteBoard(BoardVO vo) throws Exception{
		sqlSession.insert(Namespace+".WroteBoard", vo);
	}
	
	public BoardVO UpdateGetBoard(Integer b_num) throws Exception{
		
		BoardVO str = sqlSession.selectOne(Namespace + ".UpdateGetBoard", b_num);
		return str;
	}
	
	public void UpdateBoard(BoardVO vo) throws Exception{
		
		sqlSession.insert(Namespace + ".UpdateBoard", vo);
	}
	
	public void DeleteBoard(Integer b_num) throws Exception{
		
		sqlSession.delete(Namespace + ".DeleteBoard", b_num);
	}
	
	public void UpdateBoardHit(Integer b_num) throws Exception{
		sqlSession.update(Namespace + ".UpdateBoardHit", b_num);
	}
}
