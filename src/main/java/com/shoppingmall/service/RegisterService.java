package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.MembersVO;

public interface RegisterService {

	//아이디 중복 검사
	public int CheckID(String memberid) throws Exception;
	
	//회원가입
	public int Register(MembersVO vo) throws Exception;

	//닉네임 중복 검사
	public int CheckNickName(String nickname) throws Exception;

	//로그인 한 사람의 닉네임 가져옴
	public MembersVO ListNameAccessor(String name) throws Exception;

	//네이버 회원가입
	public int NaverRegister(MembersVO vo) throws Exception;

	//이미 디비에 저장되어있나 검사 해주는 로직
	public int NaverCheck(String string) throws Exception;

	//회원 등급과 닉네임을 가져옴
	public List<MembersVO> getMembership() throws Exception;

	//회원 등급 변경
	public int MembershipModify(MembersVO vo) throws Exception;

	//membershipflag 가져와야한다..
	public LoginVO getMembershipflag(String memberid) throws Exception;

}
