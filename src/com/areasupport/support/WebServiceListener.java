package com.areasupport.support;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

import com.areasupport.api.webservice.AreaSupportService;

public class WebServiceListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//省市区查询WebService
		Endpoint.publish("http://127.0.0.1:8888/areasupport", new AreaSupportService());
	}

}
