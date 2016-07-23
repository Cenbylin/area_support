package com.areasupport.api.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.areasupport.bean.CityBean;
import com.areasupport.bean.DistrictBean;
import com.areasupport.bean.ProvinceBean;
import com.areasupport.dao.CityDao;
import com.areasupport.dao.DistrictDao;
import com.areasupport.dao.ProvinceDao;

@WebService
public class AreaSupportService {
	//Dao层引用
	private ProvinceDao provinceDao = ProvinceDao.getInstance();
	private CityDao cityDao = CityDao.getInstance();
	private DistrictDao districtDao = DistrictDao.getInstance();
	/**
	 * 获得所有省份
	 * @return
	 */
	public @WebResult(name="provinceInfoList") List<ProvinceBean> getAllProvinces(){
		return provinceDao.getAllProvinceObjects();
	}
	/**
	 * 获得所有城市
	 * @param proId
	 * @return
	 */
	public @WebResult(name="cityInfoList") List<CityBean> getAllCities(@WebParam(name="proId") int proId){
		return cityDao.getAllCityObjectsByProId(proId);
	}
	/**
	 * 获得所有地区
	 * @param proId
	 * @return
	 */
	public @WebResult(name="districtInfoList") List<DistrictBean> getAllDistricts(@WebParam(name="cityId") int cityId){
		return districtDao.getAllDistrictObjectsByCityId(cityId);
	}
}
