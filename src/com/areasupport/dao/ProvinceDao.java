package com.areasupport.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.areasupport.bean.ProvinceBean;
import com.areasupport.support.DBConnectionManager;


public class ProvinceDao implements Serializable{
	private static final long serialVersionUID = 1L;
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
	 * 获得所有省份(map形式)
	 * @return
	 */
	public List<Map<String, Object>> getAllProvinces(){
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
	
	/**
	 * 获得所有省份(对象形式)
	 * @return
	 */
	public List<ProvinceBean> getAllProvinceObjects(){
		//兼容下划线字段，dbutils处理器
		// GenerousBeanProcessor 仅仅重写了父类BeanProcessor的mapColumnsToProperties方法
		BeanProcessor bean = new GenerousBeanProcessor();
		// 将GenerousBeanProcessor对象传递给BasicRowProcessor
		RowProcessor processor = new BasicRowProcessor(bean);
				
		Connection conn = null;
		List<ProvinceBean> provinces = null;
		final String SQL = "select pro_name,pro_id,pro_remark from t_province";  
	    try {
	        if (null == conn || conn.isClosed()){
	        	conn = DBConnectionManager.getConnection();  
	        }
	        provinces = new QueryRunner().query(conn, SQL, new BeanListHandler<ProvinceBean>(ProvinceBean.class, processor));
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {  
	    	DBConnectionManager.closeConnection(conn);
	    }  
		return provinces;
	}
	
}
