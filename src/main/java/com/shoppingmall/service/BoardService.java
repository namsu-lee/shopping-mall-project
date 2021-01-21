package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> GetBoardList(Integer cateid) throws Exception;
	public List<BoardVO> ViewBoard(Integer b_num) throws Exception;
	public BoardVO UpdateGetBoard(Integer b_num) throws Exception;
	public void WroteBoard(BoardVO vo) throws Exception;
	public void UpdateBoard(BoardVO vo) throws Exception;
	public void DeleteBoard(Integer b_num) throws Exception;
	
}
