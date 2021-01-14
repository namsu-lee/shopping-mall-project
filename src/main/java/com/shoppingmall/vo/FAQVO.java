package com.shoppingmall.vo;

public class FAQVO {
	int faqnum;
	String faqcategory;
	String faqtitle;
	String faqcontent;
	public int getFaqnum() {
		return faqnum;
	}
	public void setFaqnum(int faqnum) {
		this.faqnum = faqnum;
	}
	public String getFaqcategory() {
		return faqcategory;
	}
	public void setFaqcategory(String faqcategory) {
		this.faqcategory = faqcategory;
	}
	public String getFaqtitle() {
		return faqtitle;
	}
	public void setFaqtitle(String faqtitle) {
		this.faqtitle = faqtitle;
	}
	public String getFaqcontent() {
		return faqcontent;
	}
	public void setFaqcontent(String faqcontent) {
		this.faqcontent = faqcontent;
	}
	@Override
	public String toString() {
		return "FAQVO [faqnum=" + faqnum + ", faqcategory=" + faqcategory + ", faqtitle=" + faqtitle + ", faqcontent="
				+ faqcontent + "]";
	}
	
}
