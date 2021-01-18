package com.shoppingmall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.testVO;

@Repository
public class testDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.shoppingmall.mapper.TestMapper";
	
	public List<testVO> selectTest() throws Exception{
		return sqlSession.selectList(namespace+".getTestList");
	}
}
