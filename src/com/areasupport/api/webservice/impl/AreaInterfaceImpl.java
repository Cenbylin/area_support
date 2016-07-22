package com.areasupport.api.webservice.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebService;

import com.areasupport.api.webservice.AreaInterface;

@WebService(endpointInterface="com.areasupport.api.webservice.AreaInterface")
public class AreaInterfaceImpl implements AreaInterface {

	@Override
	public ArrayList<HashMap<String, Object>> getProvinces() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("String", "12300");
		list.add(map1);
		
		return list;
	}

}
