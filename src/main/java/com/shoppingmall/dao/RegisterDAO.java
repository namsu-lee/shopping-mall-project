package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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


	//닉네임 중복 검사
	public int CheckNickName(String nickname) {
		return sqlSession.selectOne(Namespace + ".CheckNickName", nickname);
	}


	//로그인한 사람의 닉네임 전체를 가져옴
	public MembersVO ListNameAccessor(String memberid) {
		return sqlSession.selectOne(Namespace + ".ListNickName", memberid);
	}


	
}
