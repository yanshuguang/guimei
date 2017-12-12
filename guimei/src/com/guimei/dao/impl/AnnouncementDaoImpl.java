package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guimei.dao.AnnouncementDao;
import com.guimei.entity.Announcement;
import com.guimei.entity.User;
import com.guimei.util.DBConnection;

public class AnnouncementDaoImpl implements AnnouncementDao {

	@Override
	public List<Announcement> queryAllAnnouncement() {
		
		Connection conn=DBConnection.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		List<Announcement> list=new ArrayList<Announcement>();
		String sql="select * from announcement";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				Announcement a=new Announcement();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setContent(rs.getString("content"));
				list.add(a);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			
			DBConnection.close(conn, stmt, rs);
		}
	}

	@Override
	public Announcement selectAnnouncementById(int id) {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from announcement where id=?";
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Announcement ann = new Announcement();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int userid = rs.getInt("id");
				ann.setId(userid);
				ann.setTitle(rs.getString("title"));
				ann.setContent(rs.getString("content"));
				
			}
			return ann;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {

			DBConnection.close(conn, pstmt, rs);
		}

	}

	@Override
	public void deleteAnnouncementById(int id) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from announcement where id=?";
		PreparedStatement pstmt = null;

		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

	@Override
	public void updateAnnouncement(int id ,Announcement ann) {
			Connection conn=DBConnection.getConnection();
			
			PreparedStatement pstmt=null;
			
			String sql="update announcement set title=?,content=? where id=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, ann.getTitle());
				pstmt.setString(2, ann.getContent());
				pstmt.setInt(3, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean addAnnouncement(Announcement ann) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into announcement (title,content) value(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ann.getTitle());
			pstmt.setString(2, ann.getContent());
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
