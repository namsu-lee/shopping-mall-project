package com.shoppingmall.vo;

public class testVO {
	private int testid;
    private String testcontent;
    
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getTestcontent() {
		return testcontent;
	}
	public void setTestcontent(String testcontent) {
		this.testcontent = testcontent;
	}
	@Override
	public String toString() {
		return "testDAO [testid=" + testid + ", testcontent=" + testcontent + "]";
	}
    
}
