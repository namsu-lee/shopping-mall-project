package com.shoppingmall.service;

import com.shoppingmall.vo.MembersVO;

public interface RegisterService {

	//���̵� �ߺ� �˻�
	public int CheckID(String memberid) throws Exception;
	
	//ȸ������
	public int Register(MembersVO vo) throws Exception;

}
