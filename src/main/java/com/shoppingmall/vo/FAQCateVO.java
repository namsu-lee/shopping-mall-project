package com.shoppingmall.vo;

public class FAQCateVO {
	int faqcatenum;
	String faqcategory;
	
	public int getFaqcatenum() {
		return faqcatenum;
	}
	public void setFaqcatenum(int faqcatenum) {
		this.faqcatenum = faqcatenum;
	}
	public String getFaqcategory() {
		return faqcategory;
	}
	public void setFaqcategory(String faqcategory) {
		this.faqcategory = faqcategory;
	}
	
	@Override
	public String toString() {
		return "FAQCateVO [faqcatenum=" + faqcatenum + ", faqcategory=" + faqcategory + "]";
	}
}
