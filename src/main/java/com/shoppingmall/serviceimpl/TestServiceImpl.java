package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.testDAO;
import com.shoppingmall.service.TestService;
import com.shoppingmall.vo.testVO;

@Service
public class TestServiceImpl implements TestService{
	
	@Inject
	private testDAO dao;
	
	@Override
	public List<testVO> selectTest() throws Exception{
		return dao.selectTest();
	}
}
