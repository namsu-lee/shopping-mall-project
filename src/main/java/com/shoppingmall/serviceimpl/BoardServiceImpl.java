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
	
	BoardVO boardvo = new BoardVO();
	
	@Override
	public List<BoardVO> GetBoardList(int cateid) throws Exception{
		System.out.println(cateid+"serviceimpl");
		System.out.println(boardvo.toString());
		return BoardDAO.GetBoardList(cateid);
	}
}
