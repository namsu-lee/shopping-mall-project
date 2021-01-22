package com.shoppingmall.service;

public interface VisitcountService {

	//총 방문자 수 +1
	public int PlusTotalCount() throws Exception;

	//오늘 방문자 수 +1
	public int PlusTodayCount() throws Exception;

}
