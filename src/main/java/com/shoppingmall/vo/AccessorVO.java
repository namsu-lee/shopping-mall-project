package com.shoppingmall.vo;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;


public class AccessorVO {
	// 홈페이지 접속자 수 접속자 아이디 관리
	private static ArrayList<HttpSession> httpSession = new ArrayList<HttpSession>();

	public static ArrayList<HttpSession> getHttpSession() {
		return httpSession;
	}

	public static void setHttpSession(ArrayList<HttpSession> httpSession) {
		AccessorVO.httpSession = httpSession;
	}

}
