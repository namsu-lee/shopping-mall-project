package com.shoppingmall.vo;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;


public class AccessorVO {

	private static ArrayList<HttpSession> httpSession = new ArrayList<HttpSession>();

	public static ArrayList<HttpSession> getHttpSession() {
		return httpSession;
	}

	public static void setHttpSession(ArrayList<HttpSession> httpSession) {
		AccessorVO.httpSession = httpSession;
	}
	
}
