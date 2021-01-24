package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.VisitcountDAO;
import com.shoppingmall.service.VisitcountService;
import com.shoppingmall.vo.VisitCountVO;

@Service
public class VisitcountServiceImpl implements VisitcountService{

	@Inject
	VisitcountDAO visitcountDAO;
	
	//총 방문자 수 +1
	@Override
	public int UpdateTotalCount() throws Exception {
		return visitcountDAO.UpdateTotalCount();
	}
	
	
	//오늘 방문자 수 +1
	@Override
	public int UpdateTodayCount(String memberid) throws Exception {
		return visitcountDAO.UpdateTodayCount(memberid);
	}

	
	//총 방문자 수
	@Override
	public VisitCountVO getTotalCount() throws Exception {
		return visitcountDAO.getTotalCount();
	}


	//오늘 방문자 수
	@Override
	public int getTodayCount() throws Exception {
		return visitcountDAO.getTodayCount();
	}


	//오늘 방문 했는지 안했는지 검사
	@Override
	public int getTodayUser(String memberid) throws Exception {
		return visitcountDAO.getTodayUser(memberid);
	}

}
