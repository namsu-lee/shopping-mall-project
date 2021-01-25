package com.shoppingmall.service;

import java.util.List;
import java.util.Map;

import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.NoticeVO;

public interface NoticeService {

	//게시글은 쓴 사람의 아이디 구해야 한다.
	Map<String, String> getBoardMemberid(BoardVO boardVO) throws Exception;

	//방금 작성한 댓글 번호를 가져옴
	public int getReplyNo() throws Exception;

	//notice 테이블에 저장
	public int NoticeList(NoticeVO noticeVO) throws Exception;

	//알람 리스트 가져오기
	public List<NoticeVO> getListNotice(String memberid) throws Exception;

	//알람 읽음처리
	public int ReadCheck_Change(int notice_no) throws Exception;

	//알람 삭제처리
	public int ReadCheck_Delete(int notice_no) throws Exception;

	//읽지 않은 알람의 개수를 구해옴
	public int getReadCount(String sessionID) throws Exception;

}
