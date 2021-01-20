package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.BoardDAO;
import com.shoppingmall.service.BoardService;
import com.shoppingmall.vo.BoardVO;
@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO BoardDAO;
	
	
	@Override
	public List<BoardVO> GetBoardList(Integer cateid) throws Exception{
		
		return BoardDAO.GetBoardList(cateid);
	}
	
	@Override
	public List<BoardVO> ViewBoard(Integer b_num) throws Exception{
		
		return BoardDAO.ViewBoard(b_num);
	}
	
	@Override
	public void WroteBoard(BoardVO vo) throws Exception{
		BoardDAO.WroteBoard(vo);
	}
}
