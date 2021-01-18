package com.shoppingmall.vo;

public class CategoryVO {
	private int cateid;
	private int catesort;
	private String catename;
	private String cateauth;
	private String categroup; 

	public Integer getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public Integer getCatesort() {
		return catesort;
	}
	public void setCatesort(int catesort) {
		this.catesort = catesort;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getCateauth() {
		return cateauth;
	}
	public void setCateauth(String cateauth) {
		this.cateauth = cateauth;
	}
	public String getCategroup() {
		return categroup;
	}
	public void setCategroup(String categroup) {
		this.categroup = categroup;
	}
	@Override
	public String toString() {
		return "CategoryVO [cateid=" + cateid + ", catesort=" + catesort + ", catename=" + catename + ", cateauth="
				+ cateauth + ", categroup=" + categroup + "]";
	}
	
	
}
