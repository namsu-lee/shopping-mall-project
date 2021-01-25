package com.shoppingmall.serviceimpl;

import java.util.List;
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

	//알람 리스트 가져오기
	@Override
	public List<NoticeVO> getListNotice(String memberid) throws Exception {
		return noticeDAO.getListNotice(memberid);
	}

	//알람 읽음처리
	@Override
	public int ReadCheck_Change(int notice_no) throws Exception {
		return noticeDAO.ReadCheck_Change(notice_no);
	}

	//알람 삭제처리
	@Override
	public int ReadCheck_Delete(int notice_no) throws Exception {
		return noticeDAO.ReadCheck_Delete(notice_no);
	}

	//읽지 않은 알람의 개수를 구해옴
	@Override
	public int getReadCount(String memberid) throws Exception {
		return noticeDAO.getReadCount(memberid);
	}
	
}
