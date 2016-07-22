package com.areasupport.api.webservice;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebService;

@WebService
public interface AreaInterface {
	public ArrayList<HashMap<String, Object>> getProvinces();
}
