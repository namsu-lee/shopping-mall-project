package com.shoppingmall.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.ChatDAO;
import com.shoppingmall.service.ChatService;
import com.shoppingmall.vo.ChattingBangVO;

@Service
public class ChatServiceImpl implements ChatService{

	@Inject
	ChatDAO chatDAO;
	

	//중복된 채팅방이 있는지 검사
	@Override
	public int CheckChattingBang(String title) throws Exception {
		return chatDAO.CheckChattingBang(title);
	}


	//채팅방 생성
	@Override
	public int MakeChattingBang(String title) throws Exception {
		return chatDAO.MakeChattingBang(title);
	}


	//채팅방 목록
	@Override
	public List<ChattingBangVO> getChattingBang() throws Exception {
		return chatDAO.getChattingBang();
	}


	//로그인 한 사람의 회원 등급을 가져온다.
	@Override
	public Map<String, String> getMemberShipflag(String memberid) throws Exception {
		return chatDAO.getMemberShipflag(memberid);
	}


	//채팅방 삭제
	@Override
	public int ChatTitleRemove(String title) throws Exception {
		return chatDAO.ChatTitleRemove(title);
	}
	
}
