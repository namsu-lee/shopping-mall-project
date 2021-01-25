package com.shoppingmall.vo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginVO {
	private String memberid;
	private String password;
	private String Auto_Login;		//�ڵ� �α��� üũ
	private String Auto_ID;			//���̵� ���� üũ
	private String nickname;

	

	final static char[] hexArray = "0123456789abcdef".toCharArray();

	public static byte[] sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());

		return md.digest();
	}

	public static String bytesToHex2(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public String getAuto_Login() {
		return Auto_Login;
	}

	public void setAuto_Login(String auto_Login) {
		Auto_Login = auto_Login;
	}

	public String getAuto_ID() {
		return Auto_ID;
	}

	public void setAuto_ID(String auto_ID) {
		Auto_ID = auto_ID;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "LoginVO [memberid=" + memberid + ", password=" + password + ", Auto_Login=" + Auto_Login + ", Auto_ID=" + Auto_ID + ", nickname=" + nickname + "]";
	}


}
