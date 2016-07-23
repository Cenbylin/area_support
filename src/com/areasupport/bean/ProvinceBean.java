package com.areasupport.bean;

import java.io.Serializable;

public class ProvinceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String proName;
	private int proId;
	private String proRemark;
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProRemark() {
		return proRemark;
	}
	public void setProRemark(String proRemark) {
		this.proRemark = proRemark;
	}
	
}
