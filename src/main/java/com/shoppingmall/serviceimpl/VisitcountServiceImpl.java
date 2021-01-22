package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.service.VisitcountService;

@Service
public class VisitcountServiceImpl implements VisitcountService{

	@Inject
	VisitcountDAO visitcountDAO;
	
	//총 방문자 수 +1
	@Override
	public int PlusTotalCount() throws Exception {
		return visitcountDAO.PlusTotalCount();
	}
	
	
	//오늘 방문자 수 +1
	@Override
	public int PlusTodayCount() throws Exception {
		return visitcountDAO.PlusTodayCount();
	}

}
