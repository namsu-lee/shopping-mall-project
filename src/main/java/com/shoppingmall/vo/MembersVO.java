package com.shoppingmall.vo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MembersVO {
	private String memberid;
	private String nickname;
	private String password;
	private String membername;
	private String email;
	private String address;
	private String phone;
	private String uuid = "";
	private String uploadPath = "";
	private String fileName = "man.jpg";
	private String membershipflag = "f";//a b c d f
	private String stopflag = "g";	//g or s
	
	// 회원가입시 기본이미지로 저장해준다.

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getMembershipflag() {
		return membershipflag;
	}

	public void setMembershipflag(String membershipflag) {
		this.membershipflag = membershipflag;
	}

	public String getStopflag() {
		return stopflag;
	}

	public void setStopflag(String stopflag) {
		this.stopflag = stopflag;
	}

	@Override
	public String toString() {
		return "MembersVO [memberid=" + memberid + ", nickname=" + nickname + ", password=" + password + ", membername="
				+ membername + ", email=" + email + ", address=" + address + ", phone=" + phone + ", uuid=" + uuid
				+ ", uploadPath=" + uploadPath + ", fileName=" + fileName + ", membershipflag=" + membershipflag
				+ ", stopflag=" + stopflag + "]";
	}

	// 난수 생성
	public String Random_Number() {

		int len = 6;
		int dupCd = 1;
		Random rand = new Random();
		String numStr = ""; // 이메일 인증 번호

		for (int i = 0; i < len; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			if (dupCd == 1) {
				numStr += ran;
			} else if (dupCd == 2) {
				if (!numStr.contains(ran)) {
					numStr += ran;
				} else {
					i -= 1;
				}
			}
		}
		return numStr;
	}
}
