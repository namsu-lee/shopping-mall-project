package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.CategoryVO;
public interface CategoryService {
	
	public List<CategoryVO> CategoryGet() throws Exception;
	
	public void CategoryInsert(CategoryVO vo) throws Exception;
//	public void CategoryUpdate() throws Exception;
//	public void CategoryDelete() throws Exception;
}
