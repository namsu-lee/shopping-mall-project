package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.RegisterDAO;
import com.shoppingmall.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService{

	
	@Inject
	RegisterDAO registerDAO;

	
	//���̵� �ߺ� �˻�
	@Override
	public int CheckID(String memberid) throws Exception {
		return registerDAO.CheckID(memberid);
	}
		
}
