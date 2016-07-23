package com.areasupport.bean;

import java.io.Serializable;

public class DistrictBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String disName;
	private int disId;
	public String getDisName() {
		return disName;
	}
	public void setDisName(String disName) {
		this.disName = disName;
	}
	public int getDisId() {
		return disId;
	}
	public void setDisId(int disId) {
		this.disId = disId;
	}
	
}
