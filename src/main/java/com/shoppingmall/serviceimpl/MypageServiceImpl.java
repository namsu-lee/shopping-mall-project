package com.shoppingmall.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shoppingmall.dao.MypageDAO;
import com.shoppingmall.service.MypageService;
import com.shoppingmall.vo.MembersVO;

@Service
public class MypageServiceImpl implements MypageService {

	@Inject
	MypageDAO mypageDAO;
	
	//마이페이지 수정
	public int MypageUpdate(MembersVO vo) throws Exception {
		return mypageDAO.MypageUpdate(vo);
	}

	//마이페이지 리스트
	@Override
	public MembersVO MypageList(String memberid) throws Exception {
		return mypageDAO.MypageList(memberid);
	}

	
	//오늘 기준 어제 파일 정보
	@Override
	public List<MembersVO> getOldFiles() throws Exception {
		return mypageDAO.getOldFiles();
	}

}
