package com.areasupport.service;

import java.util.List;
import java.util.Map;

import com.areasupport.dao.CityDao;
import com.areasupport.dao.DistrictDao;
import com.areasupport.dao.ProvinceDao;

/**
 * 省市区查询service
 * @author Cenby7
 *
 */
public class AreaQueryService {
	private static AreaQueryService instance;
	/**私有构造方法*/
	private AreaQueryService(){}
	/**获得实例*/
	public static AreaQueryService getInstance() {
		if (instance == null) {
			instance = new AreaQueryService() ;
		}
		return instance ;
	}
	/**
	 * 获得所有省份
	 * @return
	 */
	public List<Map<String, Object>> getAllProvinces(){
		ProvinceDao provinceDao = ProvinceDao.getInstance();
		return provinceDao.getAllProvinces();
	}
	/**
	 * 获得所有城市
	 * @param proId
	 * @return
	 */
	public List<Map<String, Object>> getAllCities(int proId){
		CityDao cityDao = CityDao.getInstance();
		return cityDao.getAllCitiesByProId(proId);
	}
	/**
	 * 获得所有地区
	 * @param proId
	 * @return
	 */
	public List<Map<String, Object>> getAllDistricts(int cityId){
		DistrictDao districtDao = DistrictDao.getInstance();
		return districtDao.getAllDistrictsByCityId(cityId);
	}
}
