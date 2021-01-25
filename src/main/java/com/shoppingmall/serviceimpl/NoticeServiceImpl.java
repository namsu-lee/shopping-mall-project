package com.shoppingmall.serviceimpl;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.NoticeDAO;
import com.shoppingmall.service.NoticeService;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Inject
	NoticeDAO noticeDAO;
	
	//게시글은 쓴 사람의 아이디 구해야 한다.
	@Override
	public Map<String, String> getBoardMemberid(BoardVO boardVO)  throws Exception {
		return noticeDAO.getBoardMemberid(boardVO);
	}

	//방금 작성한 댓글 번호를 가져옴
	@Override
	public int getReplyNo() throws Exception {
		return noticeDAO.getReplyNo();
	}

	//notice 테이블에 저장
	@Override
	public int NoticeList(NoticeVO noticeVO) throws Exception {
		return noticeDAO.NoticeList(noticeVO);
	}
	
}
