package com.shoppingmall.vo;

public class LoginVO {
	private String memberid;
	private String password;

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

	@Override
	public String toString() {
		return "LoginVO [memberid=" + memberid + ", password=" + password + "]";
	}

}
