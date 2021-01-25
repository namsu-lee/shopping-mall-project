package com.shoppingmall.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.NoticeVO;

@Repository
public class NoticeDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.NoticeMapper";

	
	//게시글은 쓴 사람의 아이디 구해야 한다.
	public Map<String, String> getBoardMemberid(BoardVO boardVO) {
		return sqlSession.selectOne(Namespace + ".getBoardMemberid", boardVO);
	}


	//방금 작성한 댓글 번호를 가져옴
	public int getReplyNo() {
		return sqlSession.selectOne(Namespace + ".getReplyNo");
	}


	//notice 테이블에 저장
	public int NoticeList(NoticeVO noticeVO) {
		return sqlSession.insert(Namespace + ".NoticeList", noticeVO);
	}
}