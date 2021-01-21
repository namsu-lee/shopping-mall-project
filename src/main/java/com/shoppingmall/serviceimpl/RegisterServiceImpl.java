package com.shoppingmall.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.RegisterDAO;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.MembersVO;
@Service
public class RegisterServiceImpl implements RegisterService{

	
	@Inject
	RegisterDAO registerDAO;

	
	//아이디 중복 검사
	@Override
	public int CheckID(String memberid) throws Exception {
		return registerDAO.CheckID(memberid);
	}


	//회원가입
	@Override
	public int Register(MembersVO vo) throws Exception {
		return registerDAO.Register(vo);
	}


	//닉네임 중복 검사
	@Override
	public int CheckNickName(String nickname) throws Exception {
		return registerDAO.CheckNickName(nickname);
	}


	//로그인 한 사람의 닉네임 가져옴
	@Override
	public List<Map<String,String>> ListNameAccessor(String memberid) throws Exception {
		return registerDAO.ListNameAccessor(memberid);
	}  
 
	
	
}
