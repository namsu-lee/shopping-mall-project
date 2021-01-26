package com.shoppingmall.service;

import java.util.List;

import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.Pagination;

public interface BoardService {
	public List<BoardVO> GetBoardList(Integer cateid, Integer page, String keyword, int startList, int listSize) throws Exception;
	public BoardVO ViewBoard(Integer b_num) throws Exception;
	public BoardVO UpdateGetBoard(Integer b_num) throws Exception;
	public void WroteBoard(BoardVO vo) throws Exception;
	public void UpdateBoard(BoardVO vo) throws Exception;
	public void UpdateBoardHit(Integer b_num) throws Exception;
	public void DeleteBoard(Integer b_num) throws Exception;
	public int getBoardListCnt(Integer cateid, String keyword) throws Exception;
	public List<BoardVO> getWriterBoard(String nickname) throws Exception;
}
