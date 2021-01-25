package com.shoppingmall.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.BoardVO;
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


	//알람 리스트 가져오기
	public List<NoticeVO> getListNotice(String memberid) {
		return sqlSession.selectList(Namespace + ".getListNotice", memberid);
	}


	//알람 읽음처리
	public int ReadCheck_Change(int notice_no) {
		return sqlSession.update(Namespace + ".ReadCheck_Change", notice_no);
	}


	//알람 삭제처리
	public int ReadCheck_Delete(int notice_no) {
		return sqlSession.delete(Namespace + ".ReadCheck_Delete", notice_no);
	}


	//읽지 않은 알람의 개수를 구해옴
	public int getReadCount(String memberid) {
		return sqlSession.selectOne(Namespace + ".getReadCount", memberid);
	}
}