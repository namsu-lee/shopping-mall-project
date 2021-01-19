package com.shoppingmall.vo;

import java.sql.Date;

public class BoardVO {
	private Integer b_num;
    private String memberid;
    private String nickname;
    private int cateid;
    private String b_title;
    private String b_content;
    private Date b_wdate;
    private Integer b_hit;
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
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_wdate() {
		return b_wdate;
	}
	public void setB_wdate(Date b_wdate) {
		this.b_wdate = b_wdate;
	}
	public Integer getB_hit() {
		return b_hit;
	}
	public void setB_hit(Integer b_hit) {
		this.b_hit = b_hit;
	}
	@Override
	public String toString() {
		return "BoardVO [b_num=" + b_num + ", memberid=" + memberid + ", nickname=" + nickname + ", cateid=" + cateid + ", b_title=" + b_title + ", b_content=" + b_content + ", b_wdate=" + b_wdate + ", b_hit=" + b_hit + "]";
	}
    
    
}
