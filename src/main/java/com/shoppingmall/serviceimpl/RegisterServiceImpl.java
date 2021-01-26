package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.RegisterDAO;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.MembersVO;
@Service
public class RegisterServiceImpl implements RegisterService{

	
	@Inject
	RegisterDAO registerDAO;

	
	//���̵� �ߺ� �˻�
	@Override
	public int CheckID(String memberid) throws Exception {
		return registerDAO.CheckID(memberid);
	}


	//ȸ������
	@Override
	public int Register(MembersVO vo) throws Exception {
		return registerDAO.Register(vo);
	}


	//�г��� �ߺ� �˻�
	@Override
	public int CheckNickName(String nickname) throws Exception {
		return registerDAO.CheckNickName(nickname);
	}


	//�α��� �� ����� �г��� ������
	@Override
	public MembersVO ListNameAccessor(String memberid) throws Exception {
		return registerDAO.ListNameAccessor(memberid);
	}


	//���̹� ȸ������
	@Override
	public int NaverRegister(MembersVO vo) throws Exception {
		return registerDAO.NaverRegister(vo);
	}


	//�̹� ��� ����Ǿ��ֳ� �˻� ���ִ� ����
	@Override
	public int NaverCheck(String memberid) throws Exception {
		return registerDAO.NaverCheck(memberid);
	}


	//ȸ�� ��ް� �г����� ������
	@Override
	public List<MembersVO> getMembership() throws Exception {
		return registerDAO.getMembership();
	}


	//ȸ�� ��� ����
	@Override
	public int MembershipModify(MembersVO vo) throws Exception {
		return registerDAO.MembershipModify(vo);
	}  
 
	
	
}
