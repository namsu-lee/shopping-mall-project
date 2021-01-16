package com.shoppingmall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.CategoryVO;

@Repository
public class CategoryDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.CategoryMapper";
	
		
		// 카테고리 가져오기
		public List<CategoryVO> CategoryGet() {
			return sqlSession.selectList(Namespace+".getCategoryList");
		}
		// 카테고리 번호 가져오기
		public int CategoryNumGet() {
			return sqlSession.selectOne(Namespace+".getCategoryNum");
		}
		
		// 카테고리 입력
		public void CategoryInsert(int CateNum) {
			sqlSession.update(Namespace, CateNum);
			sqlSession.commit();
		}
		
		
		// 카테고리 수정
		public void CategoryUpdate(int CateNum) {
			sqlSession.update(Namespace, CateNum);
			sqlSession.commit();
		}
		
		// 카테고리 삭제
		public void CategoryDelete(int CateNum){
			sqlSession.delete(Namespace, CateNum);
			sqlSession.commit();
		}
}
