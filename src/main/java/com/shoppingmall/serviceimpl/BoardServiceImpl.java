package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.BoardDAO;
import com.shoppingmall.service.BoardService;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.Pagination;
@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO BoardDAO;
	
	
	@Override
	public List<BoardVO> GetBoardList(Integer cateid, Integer page, String keyword, int startList, int listSize) throws Exception{
		return BoardDAO.GetBoardList(cateid, page, keyword, startList, listSize);
	}
	
	@Override
	public BoardVO ViewBoard(Integer b_num) throws Exception{
		
		return BoardDAO.ViewBoard(b_num);
	}
	
	@Override
	public BoardVO UpdateGetBoard(Integer b_num) throws Exception{
		
		return BoardDAO.UpdateGetBoard(b_num);
	}
	
	@Override
	public void WroteBoard(BoardVO vo) throws Exception{
		BoardDAO.WroteBoard(vo);
	}
	
	@Override
	public void UpdateBoard(BoardVO vo) throws Exception{
		BoardDAO.UpdateBoard(vo);
	}
	
	@Override
	public void UpdateBoardHit(Integer b_num) throws Exception{
		BoardDAO.UpdateBoardHit(b_num);
	}
	
	@Override
	public void DeleteBoard(Integer b_num) throws Exception{
		BoardDAO.DeleteBoard(b_num);
	}
	
	@Override
	public int getBoardListCnt(Integer cateid) throws Exception {
		return BoardDAO.getBoardListCnt(cateid);
	}

}
