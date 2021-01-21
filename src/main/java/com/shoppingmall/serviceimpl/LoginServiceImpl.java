package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.LoginDAO;
import com.shoppingmall.service.LoginService;
import com.shoppingmall.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{

	@Inject
	LoginDAO loginDAO;
	
	//�α���
	@Override
	public LoginVO Login(LoginVO vo) throws Exception {
		return loginDAO.Login(vo); 
	}
}
