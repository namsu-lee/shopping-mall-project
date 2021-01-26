package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.service.PauseService;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.MembersVO;
import com.shoppingmall.vo.PauseVO;

@Controller
public class MembershipController {
	
	@Inject
	RegisterService registerService;
	
	@Inject
	PauseService pauseService;
	
	//불러오기
	@RequestMapping(value = "/Membership", method = RequestMethod.GET)
	public String Membership(Locale locale, Model model) throws Exception {

		//회원 등급과 닉네임을 가져옴
		List<MembersVO> list = registerService.getMembership();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getNickname() + " :: " + list.get(i).getMembershipflag());
		}
		//System.out.println(list.get(0).toString());
		model.addAttribute("list", list);
		return "/MembershipLevel";
	}
	
	
	//회원 등급 변경
	@ResponseBody
	@RequestMapping(value = "/Membershipmodify", method = RequestMethod.POST)
	public Map<String, Integer> MembershipModify(Locale locale, Model model, MembersVO vo) throws Exception {

		//업데이트 구문
		System.out.println(vo.toString());
		int num = registerService.MembershipModify(vo);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return map;
	}
	
	//회원 정지 추가
	@ResponseBody
	@RequestMapping(value = "/Membershipstop", method = RequestMethod.POST)
	public Map<String, Integer> Membershipstop(Locale locale, Model model, PauseVO vo) throws Exception {

		//정지기능 구문 PauseVO
		System.out.println(vo.toString());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		//회원의 stopflag 업데이트
		pauseService.updateMemberStopflag(vo);
		map.put("num", pauseService.insertMembershipstop(vo));
		
		return map;
	}
	

	//회원 정지 해지
	@ResponseBody
	@RequestMapping(value = "/stopcancelmember", method = RequestMethod.POST)
	public Map<String, Integer> stopcancelmember(Locale locale, Model model, PauseVO vo) throws Exception {

		System.out.println(vo.toString());
		Map<String, Integer> map = new HashMap<String, Integer>();
		//회원 정지 해지1
		int num = pauseService.Modifystopflag(vo);
		if(num == 1) {
			int result = 0;
			result = pauseService.RemoveNick(vo);
			System.out.println("result == " + result);
			//회원 정지 해지2 			1
			map.put("num", result);
		}
		else {
			map.put("num", 0);
		}
		
		return map;
	}
}
