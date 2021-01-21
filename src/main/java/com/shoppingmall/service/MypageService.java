package com.shoppingmall.service;

import com.shoppingmall.vo.MembersVO;

public interface MypageService {

	//마이페이지 수정
	public int MypageUpdate(MembersVO vo) throws Exception;

	//마이페이지 리스트
	public MembersVO MypageList(String memberid) throws Exception;
}
