package com.areasupport.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.areasupport.support.DBConnectionManager;


public class ProvinceDao {
	private static ProvinceDao instance;
	/**私有构造方法*/
	private ProvinceDao(){}
	/**获得实例*/
	public static ProvinceDao getInstance() {
		if (instance == null) {
			instance = new ProvinceDao() ;
		}
		return instance ;
	}
	
	/**
	 * 获得所有省份
	 * @return
	 */
	public List<Map<String, Object>> getAllProvince(){
		Connection conn = null;
		List<Map<String, Object>> provinces = null;
		final String SQL = "select pro_name,pro_id,pro_remark from t_province";  
	    try {
	        if (null == conn || conn.isClosed()){
	        	conn = DBConnectionManager.getConnection();  
	        }
	        provinces = new QueryRunner().query(conn, SQL, new MapListHandler());
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {  
	    	DBConnectionManager.closeConnection(conn);
	    }  
		return provinces;
	}
	
}
