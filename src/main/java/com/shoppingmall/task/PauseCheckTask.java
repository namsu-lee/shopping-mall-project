package com.shoppingmall.task;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shoppingmall.service.PauseService;
import com.shoppingmall.vo.PauseVO;

@Component
public class PauseCheckTask {
	
	@Autowired
	private PauseService pauseService;
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.shoppingmall.mapper.PauseMapper";
	

	//스케줄러(하루마다 실행)
	@Scheduled(cron = "0 0 0 1 * *")
	public void PauseCheckTaskx() {
		System.out.println("::::::::::::::::::::::::::::");
		List<PauseVO> list = PauseCheck();
		System.out.println("11111111111111111");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			int result = PauseUpdate(list.get(i).toString());
			if(result == 1) {			//그냥 찍어봄
				System.out.println("222222222222222222222");
				System.out.println("stopflag update........");
			}
			else {
				System.out.println("333333333333333333333");
				System.out.println("stopflag update error........");
			}
		}
		System.out.println("444444444444444444444444");
		int num = PauseRemove();		//그냥 찍어봄
		if(num == 1) {
			System.out.println("55555555555555555555555");
			System.out.println("remove pause....");
		}
		else {
			System.out.println("66666666666666666666666");
			System.out.println("remove pause error....");
		}
		return;
	}
	
	//오늘날짜와 정지가 풀리는 날짜가 같은 닉네임가져옴
	private List<PauseVO> PauseCheck() {
		return sqlSession.selectList(Namespace + ".PauseCheck");
	}
	
	//닉네임의 stopflag를 s -> g 로 update
	private int PauseUpdate(String nickname) {
		return sqlSession.update(Namespace + ".PauseUpdate", nickname);
	}
	
	//오늘 정지풀리는 애들 싹다 지움
	private int PauseRemove() {
		return sqlSession.delete(Namespace + ".PauseRemove");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
