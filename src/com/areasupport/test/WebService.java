package com.areasupport.test;

import javax.xml.ws.Endpoint;

import com.areasupport.api.webservice.AreaSupportService;

public class WebService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8888/we", new AreaSupportService());
	}

}
