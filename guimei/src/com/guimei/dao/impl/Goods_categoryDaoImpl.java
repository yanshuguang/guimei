package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guimei.dao.Goods_categoryDao;
import com.guimei.entity.Goods_category;
import com.guimei.entity.Goods_class;
import com.guimei.util.DBConnection;

public class Goods_categoryDaoImpl  implements Goods_categoryDao {

	@Override
	public List<Goods_category> queryGoods_category(int currentPage ,int pageCount) {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Goods_category> list=new ArrayList<Goods_category>();
		int startCount = (currentPage - 1) * pageCount;
		
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			String sql="select category_id,goods_category.class_id,category_name,class_name from goods_category,goods_class where goods_category.class_id=goods_class.class_id limit "+ startCount +","+pageCount;;
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()){
				Goods_category g=new Goods_category();
				g.setCategory_id(rs.getInt("category_id"));
				g.setClass_id(rs.getInt("class_id"));
				g.setCategory_name(rs.getString("category_name"));
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
	public boolean deleteGoods_category(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
				
		try {
			conn=DBConnection.getConnection();
			String sql="delete from goods_category where category_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int i=pstmt.executeUpdate();
			
			if(i>0){
				
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
			}

	@Override
	public boolean updateGoods_category(int id, Goods_category gc) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBConnection.getConnection();
			String sql="update goods_category set category_name=? where category_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,gc.getCategory_name());
			pstmt.setInt(2, id);
			int i=pstmt.executeUpdate();
			
			if(i>0){				
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
	}

	@Override
	public Goods_category modifyGoods_category(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Goods_category gc=null;		
		try {
			conn=DBConnection.getConnection();
			String sql="select category_id,goods_category.class_id,class_name,category_name from goods_class,goods_category where goods_category.class_id=goods_class.class_id and category_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 gc=new Goods_category();
				gc.setClass_id(rs.getInt("class_id"));
				gc.setClass_name(rs.getString("class_name"));
				gc.setCategory_id(rs.getInt("category_id"));
				gc.setCategory_name(rs.getString("category_name"));
			}
			
			return gc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return gc;
		}finally{
			DBConnection.close(conn, pstmt, rs);
		}
		
		
	}

	@Override
	public boolean addGoods_category(Goods_category gc) {
		Connection conn=null;
		PreparedStatement pstmt=null;
				
		try {
			conn=DBConnection.getConnection();
			//在这里只是添加了一个小分类的名称
			String sql="insert into goods_category (category_name,class_id)value(?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,gc.getCategory_name());
			pstmt.setInt(2, gc.getClass_id());
			int i=pstmt.executeUpdate();
			if(i>0){
				
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
	}

	@Override
	public int getGoods_categoryCount() {
		Connection conn = DBConnection.getConnection();
		//查找记录数
		String sql = "select count(*) as count from goods_category ";
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

}
