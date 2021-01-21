package com.shoppingmall.service;

import java.util.List;
import java.util.Map;

import com.shoppingmall.vo.MembersVO;

public interface RegisterService {

	//���̵� �ߺ� �˻�
	public int CheckID(String memberid) throws Exception;
	
	//ȸ������
	public int Register(MembersVO vo) throws Exception;

	//�г��� �ߺ� �˻�
	public int CheckNickName(String nickname) throws Exception;

	//�α��� �� ����� �г��� ������
	public List<Map<String,String>> ListNameAccessor(String name) throws Exception;

}
