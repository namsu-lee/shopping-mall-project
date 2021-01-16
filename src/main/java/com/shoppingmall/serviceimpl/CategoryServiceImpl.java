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
	public List<CategoryVO> getCategoryList() throws Exception{
		return CategoryDAO.CategoryGet();
	}
}
