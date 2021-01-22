package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.MembersVO;

public interface MypageService {

	//마이페이지 수정
	public int MypageUpdate(MembersVO vo) throws Exception;

	//마이페이지 리스트
	public MembersVO MypageList(String memberid) throws Exception;

	//오늘 기준 어제 파일 정보
	public List<MembersVO> getOldFiles() throws Exception;
}
