package com.shoppingmall.service;

import java.util.List;
import java.util.Map;

import com.shoppingmall.vo.MembersVO;

public interface RegisterService {

	//아이디 중복 검사
	public int CheckID(String memberid) throws Exception;
	
	//회원가입
	public int Register(MembersVO vo) throws Exception;

	//닉네임 중복 검사
	public int CheckNickName(String nickname) throws Exception;

	//로그인 한 사람의 닉네임 가져옴
	public List<Map<String,String>> ListNameAccessor(String name) throws Exception;

}
