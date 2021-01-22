package com.shoppingmall.serviceimpl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class VisitcountDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.shoppingmall.mapper.VisitCountMapper";

	// 총 방문자 수 +1
	public int PlusTotalCount() {
		return sqlSession.update(Namespace + ".TotalCount");
	}

	// 오늘 방문자 수 +1
	public int PlusTodayCount() {
		return sqlSession.update(Namespace + ".TodayCount");
	}

}
