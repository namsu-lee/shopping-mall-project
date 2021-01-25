package com.shoppingmall.vo;

public class NoticeVO {
	private int board_no; //게시글 번호
	private int reply_no; //댓글  번호
	private int notice_no;//알람  번호
	private String memberid;// 게시글을 쓴 사람의 id	
	private String another_memberid;//댓글을 쓴 사람의 id
	private String read_check = "n"; //		c / n   ==>   c가 읽은거 n이 안읽은거
	private String regdate; //알람/댓글 작성일?

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getAnother_memberid() {
		return another_memberid;
	}

	public void setAnother_memberid(String another_memberid) {
		this.another_memberid = another_memberid;
	}

	public String getRead_check() {
		return read_check;
	}

	public void setRead_check(String read_check) {
		this.read_check = read_check;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "NoticeVO [board_no=" + board_no + ", reply_no=" + reply_no + ", notice_no=" + notice_no + ", memberid="
				+ memberid + ", another_memberid=" + another_memberid + ", read_check=" + read_check + ", regdate="
				+ regdate + "]";
	}

}