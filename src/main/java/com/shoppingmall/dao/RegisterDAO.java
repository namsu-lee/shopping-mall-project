package com.shoppingmall.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shoppingmall.vo.MembersVO;

@Repository
public class RegisterDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.RegisterMapper";
	


	//���̵� �ߺ� �˻�
	public int CheckID(String memberid) {
		return sqlSession.selectOne(Namespace + ".CheckID", memberid);
	}


	//ȸ������
	public int Register(MembersVO vo) {
		return sqlSession.insert(Namespace + ".Register", vo);
	}


	//�г��� �ߺ� �˻�
	public int CheckNickName(String nickname) {
		return sqlSession.selectOne(Namespace + ".CheckNickName", nickname);
	}


	//�α����� ����� �г��� ��ü�� ������
	public MembersVO ListNameAccessor(String memberid) {
		return sqlSession.selectOne(Namespace + ".ListNickName", memberid);
	}


	//���̹� ȸ������
	public int NaverRegister(MembersVO vo) {
		return sqlSession.insert(Namespace + ".NaverRegister", vo);
	}


	//�̹� ��� ����Ǿ��ֳ� �˻� ���ִ� ����
	public int NaverCheck(String memberid) {
		return sqlSession.selectOne(Namespace + ".NaverCheck", memberid);
	}


	
}
