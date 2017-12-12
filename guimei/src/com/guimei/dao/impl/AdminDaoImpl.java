package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.guimei.dao.AdminDao;
import com.guimei.util.DBConnection;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean login(String user, String password) {
		Connection conn = DBConnection.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from admin where admin_name=? and admin_pwd=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			return rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			DBConnection.close(conn, pstmt, rs);
		}

	}

	@Override
	public boolean regist(String user, String password) {
		Connection conn = DBConnection.getConnection();

		PreparedStatement pstmt = null;
		
		String sql = "insert into admin (admin_name,admin_pwd) value(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user);
			pstmt.setString(2, password);
			int i=pstmt.executeUpdate();
			if(i>=0){
				
				return true;
			}else{
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			DBConnection.close(conn, pstmt, null);
		}

	}

}
