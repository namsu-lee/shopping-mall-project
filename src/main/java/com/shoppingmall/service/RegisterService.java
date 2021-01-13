package com.shoppingmall.service;

public interface RegisterService {

	//아이디 중복 검사
	public int CheckID(String memberid) throws Exception;
	
	
}
