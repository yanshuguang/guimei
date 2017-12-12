package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guimei.dao.OrderDao;
import com.guimei.entity.Order;
import com.guimei.entity.User;
import com.guimei.util.DBConnection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<Order> selectAllOrder() {
		Connection conn = DBConnection.getConnection();
		String sql = "select order_table.*,user_realname from order_table,user where order_table.order_user_id = user.id ";
		Statement stmt = null;
//		System.out.println(sql);
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Order order=new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setUser_name(rs.getString("user_realname"));
				order.setOrder_address(rs.getString("order_address"));
				order.setOrder_status(rs.getInt("order_status"));
				
				list.add(order);
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
	/**
	 * 模糊查询
	 */
	@Override
	public List<Order> selectOrderByIdAndOrdername(int id, String name) {
		
		Connection conn = DBConnection.getConnection();
		StringBuffer sql =new StringBuffer("select order_table.*,user_realname from order_table,user where order_table.order_user_id = user.id and 1=1 ") ;
		if((Integer)id!=null &&id!=0){
//			CONVERT(VARCHAR(50),columnname) like '%查询的字符串%'  或者：cast(id as varchar(10))
			sql.append(" and cast(order_id as varchar(20))like '%"+id+"%'");
		}
		if(name!=null&& !name.equals("")){
			sql.append(" and user_realname like '%"+name+"%'");
		}
		System.out.println(sql.toString());
		Statement stmt=null;
		
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				Order order=new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setUser_name(rs.getString("user_realname"));
				order.setOrder_address(rs.getString("order_address"));
				order.setOrder_status(rs.getInt("order_status"));
				
				list.add(order);
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
	public boolean deleteOrderById(int id) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from order_table where order_id=? ";
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
		
		return false;
		
		
		} 
	

	/*@Override
	public boolean addOrder(Order order) {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into  order_table  ";
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
		
		return false;
	}
*/
	@Override
	public boolean updateOrderById(int id ,Order order) {
		Connection conn = DBConnection.getConnection();
		String sql = "update order_table set order_id=?,order_address=?,order_sum_price=?,order_date=?,order_status=? where order_id=? ";
//		Update Table1 set c = (select c from Table2 where a = Table1.a) where c is null
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, order.getOrder_address());
			pstmt.setDouble(3, order.getOrder_sum_price());
			pstmt.setString(4, order.getOrder_date());
			pstmt.setInt(5, order.getOrder_status());
			pstmt.setInt(6, order.getOrder_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(conn, pstmt, null);
		}
		
		
		return false;
	}

	@Override
	public Order selectOrderById(int id) {
		
		Connection conn = DBConnection.getConnection();
		String sql = "select order_table.*,user_realname from order_table ,user where order_table.order_user_id=user.id and order_id= ? ";
					 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Order order =null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				order=new Order();
				order.setOrder_address(rs.getString("order_address"));
				order.setOrder_id(rs.getInt("order_id"));
				order.setUser_name(rs.getString("user_realname"));
				order.setOrder_sum_price(rs.getDouble("order_sum_price"));
				order.setOrder_date(rs.getString("order_date"));
				order.setOrder_status(rs.getInt("order_status"));
			}
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {

			DBConnection.close(conn, pstmt, rs);
		}
		
	}

}
