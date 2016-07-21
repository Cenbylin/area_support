package com.areasupport.service;

/**
 * 省市区查询service
 * @author Cenby7
 *
 */
public class AreaQueryService {
	private static AreaQueryService instance;
	/**私有构造方法*/
	private AreaQueryService(){}
	/**获得实例*/
	public static AreaQueryService getInstance() {
		if (instance == null) {
			instance = new AreaQueryService() ;
		}
		return instance ;
	}
	
	
	
	
}
