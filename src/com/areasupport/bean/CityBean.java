package com.areasupport.bean;

import java.io.Serializable;

public class CityBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cityName;
	private int cityId;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
}
