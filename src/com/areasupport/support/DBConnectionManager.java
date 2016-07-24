package com.areasupport.support;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnectionManager {
	private static ComboPooledDataSource dataSource;
	//初始化连接池
	static{
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setUser(ConfigLoader.getJdbcUser());
			dataSource.setPassword(ConfigLoader.getJdbcPassword());
			dataSource.setJdbcUrl(ConfigLoader.getJdbcUrl());
			dataSource.setDriverClass(ConfigLoader.getJdbcDriver());
			dataSource.setInitialPoolSize(ConfigLoader.getJdbcInitialPoolSize());
			dataSource.setMinPoolSize(ConfigLoader.getJdbcMinPoolSize());
			dataSource.setMaxPoolSize(ConfigLoader.getJdbcMaxPoolSize());
			dataSource.setMaxStatements(ConfigLoader.getJdbcMaxStatements());
			dataSource.setMaxIdleTime(ConfigLoader.getJdbcMaxIdleTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		if(dataSource!=null){
			try {
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/**
	 * 连接关闭
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if (conn!=null) {
            try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
