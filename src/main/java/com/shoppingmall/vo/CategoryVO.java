package com.shoppingmall.vo;

public class CategoryVO {
	private int cateid;
	private int catesort;
	private String catename;
	private int cateauth;
	private String categroup; 

	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getCatesort() {
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
	public int getCateauth() {
		return cateauth;
	}
	public void setCateauth(int cateauth) {
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
