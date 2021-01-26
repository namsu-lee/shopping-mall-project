package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.PauseVO;
@Repository
public class PauseDAO {

	@Inject
	SqlSession sqlSession;
	
	
	private static final String Namespace = "com.shoppingmall.mapper.PauseMapper";
	
	
	//회원 정지 추가
	public int insertMembershipstop(PauseVO vo) {
		return sqlSession.insert(Namespace + ".insertMembershipstop", vo);
	}


	//추가 되었나 체크
	public int getMembershipNick(PauseVO vo) {
		return sqlSession.selectOne(Namespace + ".getMembershipNick", vo);
	}


	//회원의 stopflag 업데이트
	public int updateMemberStopflag(PauseVO vo) {
		return sqlSession.update(Namespace + ".updateMemberStopflag", vo);
	}


	//회원 정지 해지1
	public int Modifystopflag(PauseVO vo) {
		return sqlSession.update(Namespace + ".Modifystopflag", vo);
	}


	//회원 정지 해지2
	public int RemoveNick(PauseVO vo) {
		return sqlSession.delete(Namespace + ".RemoveNick", vo);
	}
	
	
}
