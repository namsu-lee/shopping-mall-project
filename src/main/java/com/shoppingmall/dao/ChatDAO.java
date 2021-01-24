package com.shoppingmall.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.ChattingBangVO;
@Repository
public class ChatDAO {

	@Inject
	SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.ChatMapper";
	
	//중복된 채팅방이 있는지 검사
	public int CheckChattingBang(String title) {
		return sqlSession.selectOne(Namespace + ".CheckChattingBang", title);
	}

	//채팅방 생성
	public int MakeChattingBang(String title) {
		return sqlSession.insert(Namespace + ".MakeChattingBang", title);
	}

	//채팅방 목록
	public List<ChattingBangVO> getChattingBang() {
		return sqlSession.selectList(Namespace + ".getChattingBang");
	}
	
	
}
