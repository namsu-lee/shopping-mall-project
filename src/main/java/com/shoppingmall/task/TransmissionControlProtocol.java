package com.shoppingmall.task;
//학원 주소 :: private final static String IP = "192.168.0.54";
public class TransmissionControlProtocol {
	// 서버 주소
	private final static String IP = "192.168.0.3";
	private final static int port = 5599;

	public static String getIp() {
		return IP;
	}

	public static int getPort() {
		return port;
	}

}
