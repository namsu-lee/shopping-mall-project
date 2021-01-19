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
	
		
		// 카테고리 전체 조회
		public List<CategoryVO> CategoryGet() throws Exception{
			return sqlSession.selectList(Namespace+".getCategoryList");
		}
		
		//카테고리 순서 조회
		public List<CategoryVO> CategorySortGet() throws Exception{
			return sqlSession.selectList(Namespace+".getCategorySort");
		}
		
		//카테고리 이름 조회
		public List<CategoryVO> CategoryNameGet() throws Exception{
			return sqlSession.selectList(Namespace+".getCategoryName");
		}
		
//		// 카테고리 번호 가져오기
//		public int CategoryNumGet() {
//			return sqlSession.selectOne(Namespace+".getCategoryNum");
//		}
		
//		<select id="getCategoryOne" resultType="CategoryVO">
//		select * from category order by catesort where cateid=#{cateid}
//		</select>
		
		// 카테고리 입력
		public void InsertCategory(CategoryVO vo) {
			sqlSession.update(Namespace+".insertCategory", vo);
		}
		
		
		// 카테고리 수정
		public void UpdateCategory(CategoryVO vo) {
			sqlSession.update(Namespace+".updateCategory", vo);
		}
		
		// 카테고리 삭제
		public void DeleteCategory(int CateNum){
			sqlSession.delete(Namespace+".deleteCategory", CateNum);
		}
		
		

	
}
