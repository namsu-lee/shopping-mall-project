package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.MainDAO;
import com.shoppingmall.service.MainService;
import com.shoppingmall.vo.MainVO;

@Service
public class MainServiceImpl implements MainService{
	
	@Inject
	MainDAO MainDAO;
	
	@Override
	public MainVO UpdateGetMain() throws Exception{
		return MainDAO.UpdateGetMain();
	}
	
	@Override
	public void UpdateMain(MainVO vo) throws Exception{
		MainDAO.UpdateMain(vo);
	}
}
