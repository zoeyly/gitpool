package com.neusoft.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过读取配置文件，实例化实现类对象
 * */

public class DaoFactory {
	private DaoFactory() {}
	
	private static Properties ps=new Properties();
	static {
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**		
	 * 通过反射和泛型，获取实现类的实例
	 * @param daoName   配置文件中的key
	 * @param  cls : 实现类的Class
	 * */
	//利用泛型
	@SuppressWarnings("unchecked")
	public <T> T getInstance(String daoName,Class<T> cls){
		
		T t=null;
		//空  判断
		if(null==daoName||"".equals(daoName)) {
			return t;
		}
		
		//根据daoName获取类名
		String className=ps.getProperty(daoName);
		if(className==null||"".equals(className)) {
			return t;
		}
		try {
			Class<?> clazz=Class.forName(className);
			t=(T)clazz.newInstance();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
		}catch (InstantiationException e) {
			// TODO: handle exception
		}catch (IllegalAccessException e) {
			// TODO: handle exception
		}
	
		
		return t;
	}
	
	
}
