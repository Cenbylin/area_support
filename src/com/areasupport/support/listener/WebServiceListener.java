package com.areasupport.support.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

import com.areasupport.api.webservice.AreaSupportService;
import com.areasupport.support.ConfigLoader;

public class WebServiceListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//省市区查询WebService
		Endpoint.publish(ConfigLoader.getWebserviceAddress(), new AreaSupportService());
	}

}
