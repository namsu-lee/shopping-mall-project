package com.shoppingmall.service;

import com.shoppingmall.vo.PauseVO;

public interface PauseService {

	//회원 정지 추가
	public int insertMembershipstop(PauseVO vo) throws Exception;

	//추가 되었나 체크
	public int getMembershipNick(PauseVO vo) throws Exception;

	//회원의 stopflag 업데이트
	public int updateMemberStopflag(PauseVO vo) throws Exception;

	//회원 정지 해지1
	public int Modifystopflag(PauseVO vo) throws Exception;

	//회원 정지 해지2
	public int RemoveNick(PauseVO vo) throws Exception;

}
