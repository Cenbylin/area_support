package com.areasupport.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.areasupport.bean.DistrictBean;
import com.areasupport.dao.DistrictDao;
import com.areasupport.dao.ProvinceDao;
import com.areasupport.support.DBConnectionManager;
import com.google.gson.Gson;

public class GsonTest {

	@Test
	public void gsonMapTest() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Map<String, Object> map1 = new LinkedHashMap<String, Object>();
		map1.put("sonint", 2);
		map.put("int", 1);
		map.put("bool", true);
		map.put("map", map1);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void dataSourceTest(){
		System.out.println(DBConnectionManager.getConnection());
	}
	
	@Test
	public void getAllProvinces(){
		ProvinceDao provinceDao = ProvinceDao.getInstance();
		System.out.println(provinceDao.getAllProvinces());
	}
	
	@Test
	public void daoTest(){
		DistrictDao dao = DistrictDao.getInstance();
		DistrictBean bean = dao.getDistrictObjectByDisId(1);
		System.out.println(bean.getDisName());
	}
}
