package com.neusoft.dao;

/**
 * 自定义异常
 * **/
public class DaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5172705522882394366L;

	public  DaoException() {
		
	}
	public DaoException(String message){
		super(message);
	}
	public DaoException(String message,Throwable throwable){
		super(message, throwable);
	}
	public DaoException(Throwable throwable){
		super( throwable);
	}
	
}
