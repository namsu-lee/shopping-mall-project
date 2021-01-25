package com.shoppingmall.service;

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

}
