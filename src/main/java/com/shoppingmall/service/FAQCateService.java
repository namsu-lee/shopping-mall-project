package com.shoppingmall.service;

import com.shoppingmall.serviceimpl.FAQCateServiceImpl;
import com.shoppingmall.vo.FAQCateVO;

public interface FAQCateService {
	
	
	//FAQ 카테고리 개수 구하기
		int FAQCateGetNum() throws Exception;
		
		// 카테고리 가져오기 
		String FAQCateGet() throws Exception;

		//카테고리 입력 
		String FACCateInsert(int FAQCateNum) throws Exception;

		// 카테고리 수정 
		String FAQCateUpdate(int FAQCateNum) throws Exception;

		// 카테고리 삭제
		String FAQCateDelete(int FAQCateNum) throws Exception;
	
	
}
