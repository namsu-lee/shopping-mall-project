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

import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.MembersVO;

@Controller
public class MembershipController {
	
	@Inject
	RegisterService registerService;
	
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
}
