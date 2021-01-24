package com.shoppingmall.vo;

import java.sql.Date;

public class ReplyVO {
	private Integer replynum;
	private Integer b_num;
	private String memberid;
	private String nickname;
	private String replycontent;
	private Date replydate;
	private Integer replydepth;
	public Integer getReplynum() {
		return replynum;
	}
	public void setReplynum(Integer replynum) {
		this.replynum = replynum;
	}
	public Integer getB_num() {
		return b_num;
	}
	public void setB_num(Integer b_num) {
		this.b_num = b_num;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public Date getReplydate() {
		return replydate;
	}
	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	public Integer getReplydepth() {
		return replydepth;
	}
	public void setReplydepth(Integer replydepth) {
		this.replydepth = replydepth;
	}
	@Override
	public String toString() {
		return "ReplyVO [replynum=" + replynum + ", b_num=" + b_num + ", memberid=" + memberid + ", nickname="
				+ nickname + ", replycontent=" + replycontent + ", replydate=" + replydate + ", replydepth="
				+ replydepth + "]";
	}
	
}
