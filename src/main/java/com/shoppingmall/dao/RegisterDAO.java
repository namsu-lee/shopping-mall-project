package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.AddressVO;
import com.shoppingmall.vo.MembersVO;

@Repository
public class RegisterDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.RegisterMapper";
	


	//아이디 중복 검사
	public int CheckID(String memberid) {
		return sqlSession.selectOne(Namespace + ".CheckID", memberid);
	}


	//회원가입
	public int Register(MembersVO vo) {
		return sqlSession.insert(Namespace + ".Register", vo);
	}


	//주소
	public int Address(AddressVO vo) {
		return sqlSession.insert(Namespace + ".Address", vo);
	}
	
	
}
