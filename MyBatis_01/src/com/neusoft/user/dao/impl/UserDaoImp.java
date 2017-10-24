package com.neusoft.user.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neusoft.entity.Author;
import com.neusoft.entity.Neusoft_User;
import com.neusoft.user.dao.UserDao;

public class UserDaoImp implements UserDao {
	 /**1����ȡ�����ļ�
	 2������SqlSessionFactory  
	ΪSqlSession�Ĺ��������ڽ��������ݿ�ĻỰ��
	3������SqlSession

	����ִ��sql���
	4������MyBatis�ṩ��api
	5����ѯMAP����
	6�����ؽ��
	7���ر�SqlSession
	*/
	@Override
	public Neusoft_User findUserById(int id) {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		Neusoft_User temp = session.selectOne("com.neusoft.entity.Neusoft_User.findById", id);
		
		System.out.println(temp);
		session.close();
		return null;
	}
	
	public Neusoft_User findUserById(Neusoft_User user) {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		Neusoft_User temp = session.selectOne("com.neusoft.entity.Neusoft_User.findByUserId", user);
		
		System.out.println(temp);
		session.close();
		return null;
	}
	
	
	@Override
	public Neusoft_User find(String username, String  password) {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		Neusoft_User temp = session.selectOne("com.neusoft.entity.Neusoft_User.find", map);
		System.out.println(temp);
		session.close();
		return null;
	}

	@Override
	public List<Neusoft_User> findAll() {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
	
		List<Neusoft_User> temp = session.selectList("com.neusoft.entity.Neusoft_User.findall2");
		System.out.println(temp);
		session.close();
		return null;
	}

	@Override
	public List<Neusoft_User> findAllByPage(int pageNo, int pageSize) {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		RowBounds rowBounds=new RowBounds((pageNo-1)*pageSize, pageSize);
		List<Neusoft_User> temp = session.selectList("com.neusoft.entity.Neusoft_User.findAllByPage", null,rowBounds);
		System.out.println(temp);
		session.close();
		return null;
	}

	@Override
	public List<Author> findAuthor() {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		List<Author> temp = session.selectList("com.neusoft.entity.Author.findAuthor");
		System.out.println(temp);
		session.close();
		return null;
	}

	@Override
	public Neusoft_User findUserByReader(Neusoft_User user) {
		String resource = "com/neusoft/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		Neusoft_User temp = session.selectOne("com.neusoft.entity.Neusoft_User.findAuthor",user);
		System.out.println(temp);
		session.close();
		return null;
	}

}
