package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guimei.dao.UserDao;
import com.guimei.entity.Login;
import com.guimei.entity.User;
import com.guimei.util.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(Login login, String sql) {
		Connection conn = DBConnection.getConnection();

		return false;
	}

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public int getUserCount(){
		Connection conn = DBConnection.getConnection();
		//查找记录数
		String sql = "select count(*) as count from user ";
		Statement stmt = null;
		ResultSet rs =null;
		try {
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql);
			while(rs.next()){
				return rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> selectAllUser(int currentPage ,int pageCount) {
		Connection conn = DBConnection.getConnection();
		List<User> list = new ArrayList<User>();
		int startCount = (currentPage - 1) * pageCount;
		String sql = "select * from user limit "+ startCount +","+pageCount;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_realname(rs.getString("user_realname"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {

			DBConnection.close(conn, stmt, rs);
		}

	}

	@Override
	public boolean deleteUser(int id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from user where id=?";
		try {

			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			conn.commit();
			if (i > 0) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;

		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnection.close(conn, pstmt, null);
		}

	}

	@Override
	public boolean updateUser(int id, User user) {
		Connection conn = DBConnection.getConnection();
		String sql = "update user set user_name=?,user_realname=?,user_pwd=?,user_gender=?,user_birthdate=?,user_id=?,user_email=?,user_phone=?,user_address=?  where id=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_realname());
			pstmt.setString(3, user.getUser_pwd());
			pstmt.setString(4, user.getUser_gender());
			pstmt.setString(5, user.getUser_birthdate());
			pstmt.setString(6, user.getUser_id());
			pstmt.setString(7, user.getUser_email());
			pstmt.setString(8, user.getUser_phone());
			pstmt.setString(9, user.getUser_address());
			pstmt.setInt(10, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User findUserById(int id) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user where id=?";
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int userid = rs.getInt("id");
				user.setId(userid);
				user.setUser_address(rs.getString("user_address"));
				user.setUser_birthdate(rs.getString("user_birthdate"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_family_name(rs.getString("user_family_name"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setUser_realname(rs.getString("user_realname"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_id(rs.getString("user_id"));
				user.setUser_lock(rs.getInt("user_lock"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_hobby(rs.getString("user_hobby"));
				user.setUser_image(rs.getString("user_image"));
			}
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return user;

		} finally {

			DBConnection.close(conn, pstmt, rs);
		}

	}

	@Override
	public boolean addUser(User user) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into user (user_name,user_realname,user_pwd,user_gender,user_birthdate,user_id,user_email,user_phone,user_address) value(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_realname());
			pstmt.setString(3, user.getUser_pwd());
			pstmt.setString(4, user.getUser_gender());
			pstmt.setString(5, user.getUser_birthdate());
			pstmt.setString(6, user.getUser_id());
			pstmt.setString(7, user.getUser_email());
			pstmt.setString(8, user.getUser_phone());
			pstmt.setString(9, user.getUser_address());
			pstmt.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			
			DBConnection.close(conn, pstmt, null);
		}
		
	}

}
