package com.shoppingmall.service;

public interface VisitcountService {

	//총 방문자 수 +1
	public int UpdateTotalCount() throws Exception;

	//오늘 방문자 수 +1
	public int UpdateTodayCount(String memberid) throws Exception;

	//총 방문자 수
	public int getTotalCount() throws Exception;
	
	//오늘 방문자 수
	public int getTodayCount() throws Exception;
}
