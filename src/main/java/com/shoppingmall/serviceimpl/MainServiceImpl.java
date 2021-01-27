package com.shoppingmall.serviceimpl;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.MainDAO;
import com.shoppingmall.service.MainService;
import com.shoppingmall.vo.MainVO;
import com.shoppingmall.vo.MembersVO;

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

	@Override
	public Map<String, String> getMembershipflag(String memberid) {
		return MainDAO.getMembershipflag(memberid);
	}
}
