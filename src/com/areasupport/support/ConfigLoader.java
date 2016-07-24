package com.areasupport.support;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigLoader {
	//jdbc配置
	private static String jdbcUrl;
	private static String jdbcUser;
	private static String jdbcPassword;
	private static String jdbcDriver;
	private static int jdbcInitialPoolSize;
	private static int jdbcMinPoolSize;
	private static int jdbcMaxPoolSize;
	private static int jdbcMaxStatements;
	private static int jdbcMaxIdleTime;
	//webservice配置
	private static String webserviceAddress;
	//RMI配置
	private static String rmiName;
	private static int rmiPort;
	
	static {
		//加载配置
		loadConfig();
	}
	private static void loadConfig(){
		Element root = null;
		SAXReader reader = new SAXReader();
		try {
			InputStream xmlStream = ConfigLoader.class.getClassLoader().getResourceAsStream("as-config.xml");
			Document doc = reader.read(xmlStream);	
			xmlStream.close();
			root = doc.getRootElement();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (DocumentException e2){
			e2.printStackTrace();
		}
		//三组配置项
		Element jdbcElement = root.element("jdbc");
		Element webserviceElement = root.element("webservice");
		Element rmiElement = root.element("rmi");
		//jdbc
		jdbcUrl = jdbcElement.elementText("url");
		jdbcDriver = jdbcElement.elementText("driver");
		jdbcUser = jdbcElement.elementText("user");
		jdbcPassword = jdbcElement.elementText("password");
		jdbcInitialPoolSize = Integer.parseInt(jdbcElement.elementText("initialPoolSize"));
		jdbcMaxIdleTime = Integer.parseInt(jdbcElement.elementText("maxIdleTime"));
		jdbcMaxPoolSize = Integer.parseInt(jdbcElement.elementText("maxPoolSize"));
		jdbcMaxStatements = Integer.parseInt(jdbcElement.elementText("maxStatements"));
		jdbcMinPoolSize = Integer.parseInt(jdbcElement.elementText("minPoolSize"));
		//webservice
		webserviceAddress = webserviceElement.elementText("address");
		//RMI
		rmiName = rmiElement.elementText("name");
		rmiPort = Integer.parseInt(rmiElement.elementText("port"));
		
	}
	public static String getJdbcUrl() {
		return jdbcUrl;
	}
	public static String getJdbcUser() {
		return jdbcUser;
	}
	public static String getJdbcPassword() {
		return jdbcPassword;
	}
	public static String getJdbcDriver() {
		return jdbcDriver;
	}
	public static int getJdbcInitialPoolSize() {
		return jdbcInitialPoolSize;
	}
	public static int getJdbcMinPoolSize() {
		return jdbcMinPoolSize;
	}
	public static int getJdbcMaxPoolSize() {
		return jdbcMaxPoolSize;
	}
	public static int getJdbcMaxStatements() {
		return jdbcMaxStatements;
	}
	public static int getJdbcMaxIdleTime() {
		return jdbcMaxIdleTime;
	}
	public static String getWebserviceAddress() {
		return webserviceAddress;
	}
	public static String getRmiName() {
		return rmiName;
	}
	public static int getRmiPort() {
		return rmiPort;
	}
}
