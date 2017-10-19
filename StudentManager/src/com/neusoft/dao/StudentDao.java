package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Student;

/**
 * ѧ��Dao
 * */
public interface StudentDao {

	//��ѯ    ����
	public List<Student> getStus() throws DaoException;
	//ͨ��		id		 ����
	public Student  getStus(Integer id) throws DaoException;
	//���
	public boolean insert(Student s) throws DaoException;
	//�޸�
	public boolean update(Student s) throws DaoException;
	//ɾ��
	public boolean delete(Integer id) throws DaoException;
	
}
