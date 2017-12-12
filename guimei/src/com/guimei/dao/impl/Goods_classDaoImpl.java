package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guimei.dao.Goods_classDao;
import com.guimei.entity.Goods_class;
import com.guimei.util.DBConnection;

public class Goods_classDaoImpl implements Goods_classDao {

	@Override
	public List<Goods_class> queryGoods_class() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Goods_class> list=new ArrayList<Goods_class>();
		
		
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			String sql="select * from goods_class";
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()){
				Goods_class g=new Goods_class();
				g.setClass_id(rs.getInt("class_id"));
				g.setClass_name(rs.getString("class_name"));
				list.add(g);
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
	public boolean deleteGoods_class(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
				
		try {
			conn=DBConnection.getConnection();
			String sql="delete from goods_class where class_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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

	@Override
	public boolean updateGoods_class(Goods_class gs, int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
				
		try {
			conn=DBConnection.getConnection();
			String sql="update goods_class set class_name=? where class_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,gs.getClass_name());
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
	}

	@Override
	public boolean addGoods_class(Goods_class gs) {
		Connection conn=null;
		PreparedStatement pstmt=null;
				
		try {
			conn=DBConnection.getConnection();
			String sql="insert into goods_class (class_name)value(?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,gs.getClass_name());
			
			pstmt.executeUpdate();
			
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
	}

	@Override
	public Goods_class selectById(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Goods_class gs=null;		
		try {
			conn=DBConnection.getConnection();
			String sql="select * from goods_class where class_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 gs=new Goods_class();
				gs.setClass_id(rs.getInt("class_id"));
				gs.setClass_name(rs.getString("class_name"));
			}
			
			return gs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return gs;
		}finally{
			DBConnection.close(conn, pstmt, rs);
		}
		
	}
	/**
	 * 查询用户是否存在
	 */
	@Override
	public boolean queryGooods_classByName(String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from goods_class where class_name=?";
		try {
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			boolean flag=pstmt.executeQuery().next();
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
	}

}
