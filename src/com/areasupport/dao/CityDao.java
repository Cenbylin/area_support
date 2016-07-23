package com.areasupport.dao;

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

import com.areasupport.bean.CityBean;
import com.areasupport.support.DBConnectionManager;


public class CityDao {
	private static CityDao instance;
	/**私有构造方法*/
	private CityDao(){}
	/**获得实例*/
	public static CityDao getInstance() {
		if (instance == null) {
			instance = new CityDao() ;
		}
		return instance ;
	}
	/**
	 * 根据pro_id获得所有城市(map形式)
	 * @param proId
	 * @return
	 */
	public List<Map<String, Object>> getAllCitiesByProId(int proId){
		Connection conn = null;
		List<Map<String, Object>> cities = null;
		final String SQL = "select city_name,city_id from t_city where pro_id=?";  
	    try {
	        if (null == conn || conn.isClosed()){
	        	conn = DBConnectionManager.getConnection();
	        }
	        cities = new QueryRunner().query(conn, SQL, new MapListHandler(), new Object[]{proId});
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {  
	    	DBConnectionManager.closeConnection(conn);
	    }  
		return cities;
	}
	/**
	 * 根据pro_id获得所有城市(对象形式)
	 * @param proId
	 * @return
	 */
	public List<CityBean> getAllCityObjectsByProId(int proId){
		//兼容下划线字段，dbutils处理器
		// GenerousBeanProcessor 仅仅重写了父类BeanProcessor的mapColumnsToProperties方法
		BeanProcessor bean = new GenerousBeanProcessor();
		// 将GenerousBeanProcessor对象传递给BasicRowProcessor
		RowProcessor processor = new BasicRowProcessor(bean);
		
		Connection conn = null;
		List<CityBean> cities = null;
		final String SQL = "select city_name,city_id from t_city where pro_id=?";  
	    try {
	        if (null == conn || conn.isClosed()){
	        	conn = DBConnectionManager.getConnection();
	        }
	        cities = new QueryRunner().query(conn, SQL, new BeanListHandler<CityBean>(CityBean.class, processor), new Object[]{proId});
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {  
	    	DBConnectionManager.closeConnection(conn);
	    }  
		return cities;
	}
	
}
