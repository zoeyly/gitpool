package com.neusoft.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ͨ����ȡ�����ļ���ʵ����ʵ�������
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
	 * ͨ������ͷ��ͣ���ȡʵ�����ʵ��
	 * @param daoName   �����ļ��е�key
	 * @param  cls : ʵ�����Class
	 * */
	//���÷���
	@SuppressWarnings("unchecked")
	public <T> T getInstance(String daoName,Class<T> cls){
		
		T t=null;
		//��  �ж�
		if(null==daoName||"".equals(daoName)) {
			return t;
		}
		
		//����daoName��ȡ����
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
