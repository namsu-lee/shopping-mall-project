package com.shoppingmall.common;

import java.util.List;

import com.shoppingmall.vo.BoardVO;

public class Xss {
	public static List<BoardVO> toJS(BoardVO vo){
		return (List<BoardVO>) vo;
	}
}
