package com.shoppingmall.serviceimpl;

import java.util.List;

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
	
}
