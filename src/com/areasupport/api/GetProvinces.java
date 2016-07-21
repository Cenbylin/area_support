package com.areasupport.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.areasupport.support.MVCControler;
import com.google.gson.Gson;

public class GetProvinces extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用service执行查询获得省份list
		List<Map<String, Object>> provinces = null;
		
		//封装json异步返回
		Gson gson = new Gson();
		MVCControler.ajax(gson.toJson(provinces), "text/html", request, response);
	}

}
