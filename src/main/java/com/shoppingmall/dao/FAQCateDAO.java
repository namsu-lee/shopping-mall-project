package com.shoppingmall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.FAQCateVO;

@Repository
public class FAQCateDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.FAQCateMapper";
	
	// 카테고리 개수 구하기
	public int FAQCateGetNum() {
		return sqlSession.selectOne(Namespace + ".CheckID");
	}
	
	// 카테고리 가져오기
	public List<FAQCateVO> FAQCateGet() {
		return sqlSession.selectList("FAQCateDAO.FAQCateGet");
	}
	
	// 카테고리 입력
	public void FAQCateInsert(int FAQCateNum) {
		sqlSession.update("FAQCateDAO.FAQCateInsert", FAQCateNum);
		sqlSession.commit();
	}
	
	// 카테고리 수정
	public void FAQCateUpdate(int FAQCateNum) {
		sqlSession.update("FAQCateDAO.FAQCateUpdate", FAQCateNum);
		sqlSession.commit();
	}
	
	// 카테고리 삭제
	public void FAQCateDelete(int FAQCateNum){
		sqlSession.delete("FAQCateDAO.FAQCateDelete", FAQCateNum);
		sqlSession.commit();
	}
	
}





	
