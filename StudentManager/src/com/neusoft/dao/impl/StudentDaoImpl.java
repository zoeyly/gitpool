package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.StudentDao;
import com.neusoft.entity.Student;
import com.neusoft.util.DBUtils;

public class StudentDaoImpl implements StudentDao {
	//��ѯ ����
	public List<Student> getStus() throws DaoException{
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			// step3:��ȡstatment
			st = conn.createStatement();
			// step4:׼��sql
			String sql = "select id,name,sex,age,myclass,address,phone,email from student";
//			System.out.println(sql);

			// step5:����sql
			rs = st.executeQuery(sql);
			// step6:�����ؽ��
			while (rs.next()) {
				Student student = new Student();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sex = rs.getInt(3);
				int age = rs.getInt(4);
				String myclass = rs.getString(5);
				String address = rs.getString(6);
				int phone = rs.getInt(7);
				String email = rs.getString(8);
				student.setId(id);
				student.setName(name);
				student.setName(name);
				student.setSex(sex);
				student.setAge(age);
				student.setMyclass(myclass);
				student.setAddress(address);
				student.setPhone(phone);
				student.setEmail(email);
				list.add(student);
			}

		} catch (SQLException e) {
			throw new DaoException("��ѯ����",e);
		} finally {
			// step7:�ر�����
			DBUtils.close(conn, st, rs);

		}

		return list;

	}
	
	//ͨ��id��ѯ
	public Student getStus(Integer id)  throws DaoException{
		Student student  = null;
					//Connection  ����
		Connection conn = null;
					//PreparedStatement��û��sqlע�룩  				Statement����sqlע�룩	׼��
		PreparedStatement ps = null;
					//ResultSet  �����
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			// step3:��ȡstatment
		
			// step4:׼��sql
			String sql = "select  id,name,sex,age,myclass,address,phone,email  from student where id= ?";	
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
//			System.out.println(sql);
			// step5:����sql
			rs = ps.executeQuery();
			// step6:�����ؽ��
			rs.next();
				student = new Student();
				 int sid = rs.getInt("id");
				String name = rs.getString("name");
				int sex=rs.getInt("sex");
				int age=rs.getInt("age");
				String myclass=rs.getString("myclass");
				String address=rs.getString("address");
				int phone =rs.getInt("phone");
				String email=rs.getString("email");
				student.setId(sid);
				student.setName(name);
				student.setSex(sex);
				student.setAge(age);
				student.setMyclass(myclass);
				student.setAddress(address);
				student.setPhone(phone);
				student.setEmail(email);
				
		} catch (SQLException e) {
			throw new DaoException("��ѯ����",e);
		} finally {
			// step7:�ر�����
			DBUtils.close(conn, ps, rs);
		}
		return student;
	}
	
	//����
	public boolean insert(Student s)  throws DaoException{
		Connection conn = null;
		PreparedStatement st = null;
		try {

			conn = DBUtils.getConnection();
			// step4:׼��sql
			String sql = "insert into student(id,name,sex,age,myclass,address,phone,email) values(?,?,?,?,?,?,?,?)";
//			System.out.println(sql);
			// step3:��ȡstatment
			st = conn.prepareStatement(sql);
			st.setInt(1, s.getId());
			st.setString(2, s.getName());
			st.setInt(3, s.getSex());
			st.setInt(4, s.getAge());
			st.setString(5, s.getMyclass());
			st.setString(6, s.getAddress());
			st.setInt(7, s.getPhone());
			st.setString(8, s.getEmail());
		
			// step5:����sql
			int count = st.executeUpdate();
			// step6:�����ؽ��
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			throw new DaoException("�������",e);
		} finally {
			// step7:�ر�����
			DBUtils.close(conn, st);

		}

		return false;
	}

	//�޸�
	public boolean update(Student s)  throws DaoException{
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update student set name=?, sex=?,age=?, myclass=?,address=?,phone=?,email=?  where id=?";
//			System.out.println(sql);
			st = conn.prepareStatement(sql);
			st.setString(1, s.getName());
			st.setInt(2, s.getSex());
			st.setInt(3, s.getAge());
			st.setString(4, s.getMyclass());
			st.setString(5, s.getAddress());
			st.setInt(6, s.getPhone());
			st.setString(7, s.getEmail());
			st.setInt(8, s.getId());
			// step5:����sql
			int count = st.executeUpdate();
			// step6:�����ؽ��
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			throw new DaoException("�޸ĳ���",e);
		} finally {
			// step7:�ر�����
			DBUtils.close(conn, st);

		}

		
		return false;
	}
	
	//ɾ��
	public boolean delete(Integer id)  throws DaoException{

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();// step3:��ȡstatment
		
			// step4:׼��sql
			String sql = "delete from student where id=?";
//			System.out.println(sql);
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			// step5:����sql
			int count = st.executeUpdate();
			// step6:�����ؽ��
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			throw new DaoException("ɾ������",e);
		} finally {
			// step7:�ر�����
			DBUtils.close(conn, st);

		}
		return false;
	}

}
