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

import com.areasupport.bean.DistrictBean;
import com.areasupport.support.DBConnectionManager;

public class DistrictDao {
	private static DistrictDao instance;
	/**私有构造方法*/
	private DistrictDao(){}
	/**获得实例*/
	public static DistrictDao getInstance() {
		if (instance == null) {
			instance = new DistrictDao() ;
		}
		return instance ;
	}
	/**
	 * 根据city_id获得所有地区(map形式)
	 * @param cityId
	 * @return
	 */
	public List<Map<String, Object>> getAllDistrictsByCityId(int cityId){
		Connection conn = null;
		List<Map<String, Object>> districts = null;
		final String SQL = "select dis_name,dis_id from t_district where city_id=?";  
	    try {
	        if (null == conn || conn.isClosed()){
	        	conn = DBConnectionManager.getConnection();
	        }
	        districts = new QueryRunner().query(conn, SQL, new MapListHandler(), new Object[]{cityId});
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally {  
	    	DBConnectionManager.closeConnection(conn);
	    }  
		return districts;
	}
	/**
	 * 根据city_id获得所有地区(对象形式)
	 * @param cityId
	 * @return
	 */
	public List<DistrictBean> getAllDistrictObjectsByCityId(int cityId){
		//兼容下划线字段，dbutils处理器
		// GenerousBeanProcessor 仅仅重写了父类BeanProcessor的mapColumnsToProperties方法
		BeanProcessor bean = new GenerousBeanProcessor();
		// 将GenerousBeanProcessor对象传递给BasicRowProcessor
		RowProcessor processor = new BasicRowProcessor(bean);
		
		Connection conn = null;
		List<DistrictBean> districts = null;
		final String SQL = "select dis_name,dis_id from t_district where city_id=?";
	    try {
	        if (null == conn || conn.isClosed()){
	        	conn = DBConnectionManager.getConnection();
	        }
	        districts = new QueryRunner().query(conn, SQL, new BeanListHandler<DistrictBean>(DistrictBean.class, processor), new Object[]{cityId});
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnectionManager.closeConnection(conn);
	    }  
		return districts;
	}
	
	
}
