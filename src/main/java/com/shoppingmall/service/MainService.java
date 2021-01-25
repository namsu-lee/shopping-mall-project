package com.shoppingmall.service;

import com.shoppingmall.vo.MainVO;

public interface MainService {
	public MainVO UpdateGetMain() throws Exception;
	public void UpdateMain(MainVO vo) throws Exception;
}
