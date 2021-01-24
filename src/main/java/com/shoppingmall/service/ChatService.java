package com.shoppingmall.service;

import java.util.List;
import java.util.Map;

public interface ChatService {

	//중복된 채팅방이 있는지 검사
	public int CheckChattingBang(String title) throws Exception;

	//채팅방 생성
	public int MakeChattingBang(String title) throws Exception;

	
	//채팅방 목록
	public List<Map<String, String>> getChattingBang() throws Exception;

	
}
