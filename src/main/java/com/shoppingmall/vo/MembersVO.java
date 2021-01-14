package com.shoppingmall.vo;

import java.util.Random;

public class MembersVO {
	String memberid;
	String password;
	String membername;
	String email;
	String phone;
	String flag;

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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "MembersVO [memberid=" + memberid + ", password=" + password + ", membername=" + membername + ", email="
				+ email + ", phone=" + phone + ", flag=" + flag + "]";
	}

	//난수 생성기
	public String Random_Number() {
		// 인증번호 생성하는 부분
		int len = 6;
		int dupCd = 1; // 1 중복허용 , 2 중복제거
		Random rand = new Random();
		String numStr = ""; // 난수가 저장될 변수

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
