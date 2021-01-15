package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.LoginVO;

@Repository
public class LoginDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.LoginMapper";
	
	//·Î±×ÀÎ
	public LoginVO Login(LoginVO vo) {
		return sqlSession.selectOne(Namespace + ".LoginCheck", vo);
	}

}