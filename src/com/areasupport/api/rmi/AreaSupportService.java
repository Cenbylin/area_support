package com.areasupport.api.rmi;

import java.rmi.Remote;
import java.util.List;

import com.areasupport.bean.CityBean;
import com.areasupport.bean.DistrictBean;
import com.areasupport.bean.ProvinceBean;

public interface AreaSupportService extends Remote{
	/**
	 * 获得所有省份
	 * @return
	 */
	public List<ProvinceBean> getAllProvinces();
	/**
	 * 获得所有城市
	 * @param proId
	 * @return
	 */
	public List<CityBean> getAllCities(int proId);
	/**
	 * 获得所有地区
	 * @param proId
	 * @return
	 */
	public List<DistrictBean> getAllDistricts(int cityId);
}
