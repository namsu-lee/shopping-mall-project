package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.PauseDAO;
import com.shoppingmall.service.PauseService;
import com.shoppingmall.vo.PauseVO;
@Service
public class PauseServiceImpl implements PauseService{

	
	@Inject
	PauseDAO pauseDAO;
	
	 
	
	//회원 정지 추가
	@Override
	public int insertMembershipstop(PauseVO vo) throws Exception {
		return pauseDAO.insertMembershipstop(vo);
	}



	//추가 되었나 체크
	@Override
	public int getMembershipNick(PauseVO vo) throws Exception {
		return pauseDAO.getMembershipNick(vo);
	}



	//회원의 stopflag 업데이트
	@Override
	public int updateMemberStopflag(PauseVO vo) throws Exception {
		return pauseDAO.updateMemberStopflag(vo);
	}



	//회원 정지 해지1
	@Override
	public int Modifystopflag(PauseVO vo) throws Exception {
		return pauseDAO.Modifystopflag(vo);
	}


	
	//회원 정지 해지2
	@Override
	public int RemoveNick(PauseVO vo) throws Exception {
		return pauseDAO.RemoveNick(vo);
	}
	
	
}
