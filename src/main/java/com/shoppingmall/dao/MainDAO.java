package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.MainVO;

@Repository
public class MainDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.MainMapper";
	
	public MainVO UpdateGetMain() throws Exception{
		
		MainVO str = sqlSession.selectOne(Namespace + ".UpdateGetMain");
		return str;
	}
	
	public void UpdateMain(MainVO vo) throws Exception{
		
		sqlSession.update(Namespace + ".UpdateMain", vo);
	}
}
