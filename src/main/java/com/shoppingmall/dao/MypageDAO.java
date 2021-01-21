package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.LoginVO;
import com.shoppingmall.vo.MembersVO;

@Repository
public class MypageDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.MypageMapper";
	
	

	//마이페이지 수정
	public int MypageUpdate(MembersVO vo) {
		return sqlSession.update(Namespace + ".mypageUpdate", vo);
	}



	//마이페이지 리스트
	public MembersVO MypageList(String memberid) {
		return sqlSession.selectOne(Namespace + ".mypageList", memberid);
	}

}
