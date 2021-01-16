package com.shoppingmall.service;

import com.shoppingmall.vo.MembersVO;

public interface RegisterService {

	//아이디 중복 검사
	public int CheckID(String memberid) throws Exception;
	
	//회원가입
	public int Register(MembersVO vo) throws Exception;

}
