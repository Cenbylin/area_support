package com.areasupport.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.junit.Test;

import com.areasupport.api.webservice.AreaInterface;
import com.areasupport.api.webservice.impl.AreaInterfaceImpl;
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
	public void gsonListTest() throws MalformedURLException{
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("name", "第一个");
		map1.put("id", 2);
		map1.put("name", "第二个");
		list.add(map);
		list.add(map1);
		Gson gson = new Gson();
		System.out.println(gson.toJson(list));
		URL url = new URL("http://localhost:8083/webservice/?wsdl");
		QName qName = new QName("http://impl.webservice.api.areasupport.com/",
				"AreaInterfaceImplService");
		Service service = Service.create(url, qName);
		AreaInterface my = service.getPort(AreaInterface.class);
		System.out.println(my.getProvinces().get(0));
	}
	
	@Test
	public void dataSourceTest(){
		System.out.println(DBConnectionManager.getConnection());
	}
	
	@Test
	public void getAllProvinces(){
		ProvinceDao provinceDao = ProvinceDao.getInstance();
		System.out.println(provinceDao.getAllProvince());
	}
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8083/webservice/", new AreaInterfaceImpl());
	}
}
