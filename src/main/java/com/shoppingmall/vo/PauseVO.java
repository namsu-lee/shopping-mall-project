package com.shoppingmall.vo;

public class PauseVO {
	private int no;
	private String nickname;
	private String startdate;
	private String enddate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "PauseVO [no=" + no + ", nickname=" + nickname + ", startdate=" + startdate + ", enddate=" + enddate
				+ "]";
	}

}
