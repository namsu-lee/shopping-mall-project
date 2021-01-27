package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.CategoryDAO;
import com.shoppingmall.service.CategoryService;
import com.shoppingmall.vo.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Inject
	CategoryDAO CategoryDAO;
	
	@Override
	public List<CategoryVO> CategoryGet() throws Exception{
		return CategoryDAO.CategoryGet();
	}
	@Override
	public List<CategoryVO> CategorySortGet() throws Exception{
		return CategoryDAO.CategorySortGet();
	}
	@Override
	public List<CategoryVO> CategoryNameGet() throws Exception{
		return CategoryDAO.CategoryNameGet();
	}
	
	@Override
	public void CategoryInsert(CategoryVO vo) throws Exception{
		CategoryDAO.InsertCategory(vo);
	}
	@Override
	public void CategoryDelete(int CateNum) throws Exception{
		CategoryDAO.DeleteCategory(CateNum);
	}
	
	@Override
	public CategoryVO getOneCategoryName(Integer cateid) throws Exception{
		return CategoryDAO.getOneCategoryName(cateid);
	}
}
