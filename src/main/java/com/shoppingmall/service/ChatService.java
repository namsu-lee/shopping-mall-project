package com.shoppingmall.service;

import java.util.List;
import java.util.Map;

import com.shoppingmall.vo.ChattingBangVO;

public interface ChatService {

	//중복된 채팅방이 있는지 검사
	public int CheckChattingBang(String title) throws Exception;

	//채팅방 생성
	public int MakeChattingBang(String title) throws Exception;

	
	//채팅방 목록
	public List<ChattingBangVO> getChattingBang() throws Exception;

	//로그인 한 사람의 회원 등급을 가져온다.
	public Map<String, String> getMemberShipflag(String memberid) throws Exception;

	//채팅방 삭제
	public int ChatTitleRemove(String title) throws Exception;

	
}

 