package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.CategoryVO;
public interface CategoryService {
	
	public List<CategoryVO> getCategoryList() throws Exception;
	
	
}
