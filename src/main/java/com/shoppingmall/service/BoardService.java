package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> GetBoardList(Integer cateid) throws Exception;
	public List<BoardVO> ViewBoard(Integer b_num) throws Exception;
}