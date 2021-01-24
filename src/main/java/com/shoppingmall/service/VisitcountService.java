package com.shoppingmall.service;

import com.shoppingmall.vo.VisitCountVO;

public interface VisitcountService {

	//총 방문자 수 +1
	public int UpdateTotalCount() throws Exception;

	//오늘 방문자 수 +1
	public int UpdateTodayCount(String memberid) throws Exception;

	//총 방문자 수
	public VisitCountVO getTotalCount() throws Exception;
	
	//오늘 방문자 수
	public int getTodayCount() throws Exception;

	//오늘 방문 했는지 안했는지 검사
	public int getTodayUser(String memberid) throws Exception;
}
