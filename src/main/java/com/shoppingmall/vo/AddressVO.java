package com.shoppingmall.vo;

public class AddressVO {
	private String memberid;
	private String address;

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddressVO [memberid=" + memberid + ", address=" + address + "]";
	}

}
