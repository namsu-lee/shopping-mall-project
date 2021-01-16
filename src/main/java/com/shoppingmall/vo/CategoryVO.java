package com.shoppingmall.vo;

public class CategoryVO {
	private int catenum;
	private int sortnum;
	private String cateadd;
	private String catename;
	
	public int getCatenum() {
		return catenum;
	}
	public void setCatenum(int catenum) {
		this.catenum = catenum;
	}
	public int getSortnum() {
		return sortnum;
	}
	public void setSortnum(int sortnum) {
		this.sortnum = sortnum;
	}
	public String getCateadd() {
		return cateadd;
	}
	public void setCateadd(String cateadd) {
		this.cateadd = cateadd;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	@Override
	public String toString() {
		return "CategoryVO [catenum=" + catenum + ", sortnum=" + sortnum + ", cateadd=" + cateadd + ", catename="
				+ catename + "]";
	}
	
	
}
