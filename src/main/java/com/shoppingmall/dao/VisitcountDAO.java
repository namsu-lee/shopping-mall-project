package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class VisitcountDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.shoppingmall.mapper.VisitCountMapper";

	// 총 방문자 수 +1
	public int UpdateTotalCount() {
		return sqlSession.update(Namespace + ".UpdateTotalCount");
	}

	// 오늘 방문한 사람 추가
	public int UpdateTodayCount(String memberid) {
		return sqlSession.insert(Namespace + ".UpdateTodayCount", memberid);
	}

	//총 방문자 수
	public int getTotalCount() {
		return sqlSession.selectOne(Namespace + ".getTotalCount");
	}

	//오늘 방문자 수
	public int getTodayCount() {
		return sqlSession.selectOne(Namespace + ".getTodayCount");
	}

}
