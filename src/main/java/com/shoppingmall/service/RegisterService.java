package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.MembersVO;

public interface RegisterService {

	//���̵� �ߺ� �˻�
	public int CheckID(String memberid) throws Exception;
	
	//ȸ������
	public int Register(MembersVO vo) throws Exception;

	//�г��� �ߺ� �˻�
	public int CheckNickName(String nickname) throws Exception;

	//�α��� �� ����� �г��� ������
	public MembersVO ListNameAccessor(String name) throws Exception;

	//���̹� ȸ������
	public int NaverRegister(MembersVO vo) throws Exception;

	//�̹� ��� ����Ǿ��ֳ� �˻� ���ִ� ����
	public int NaverCheck(String string) throws Exception;

	//ȸ�� ��ް� �г����� ������
	public List<MembersVO> getMembership() throws Exception;

	//ȸ�� ��� ����
	public int MembershipModify(MembersVO vo) throws Exception;

	//membershipflag �����;��Ѵ�..
	public LoginVO getMembershipflag(String memberid) throws Exception;

}
