package com.shoppingmall.service;

import java.util.Map;

import com.shoppingmall.vo.MainVO;

public interface MainService {
	public MainVO UpdateGetMain() throws Exception;
	public void UpdateMain(MainVO vo) throws Exception;
	public Map<String, String> getMembershipflag(String sessionID) throws Exception;
}
