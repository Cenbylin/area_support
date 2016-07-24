package com.areasupport.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import com.areasupport.api.rmi.AreaSupportService;

public class Client {
	
	@Test
	public void rmiTest() throws MalformedURLException, RemoteException, NotBoundException{
		AreaSupportService ass = (AreaSupportService)Naming.lookup("rmi://as.cenbylin.cn:8222/areasupport");
		System.out.println(ass.getAllProvinces());
	}
}
