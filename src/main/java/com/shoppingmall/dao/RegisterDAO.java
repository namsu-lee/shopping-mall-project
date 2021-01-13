package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "edu.study.mapper.RegisterMapper";
	


	//아이디 중복 검사
	public int CheckID(String memberid) {
		return sqlSession.selectOne(Namespace + ".CheckID", memberid);
	}
	
	
}
