package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Student;

/**
 * 学生Dao
 * */
public interface StudentDao {

	//查询    所有
	public List<Student> getStus() throws DaoException;
	//通过		id		 查找
	public Student  getStus(Integer id) throws DaoException;
	//添加
	public boolean insert(Student s) throws DaoException;
	//修改
	public boolean update(Student s) throws DaoException;
	//删除
	public boolean delete(Integer id) throws DaoException;
	
}
