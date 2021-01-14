package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.RegisterDAO;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.AddressVO;
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


	//�ּ�
	@Override
	public int Address(AddressVO vo) throws Exception {
		return registerDAO.Address(vo);
	}
		
}
