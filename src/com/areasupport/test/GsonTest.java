package com.areasupport.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

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
	public void gsonListTest(){
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
	}
}
