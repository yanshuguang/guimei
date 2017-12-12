package com.guimei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guimei.dao.Goods_detailDao;
import com.guimei.entity.Goods_detail;
import com.guimei.entity.Order;
import com.guimei.util.DBConnection;

public class Goods_detailDaoImpl implements Goods_detailDao {

	@Override
	public List<Goods_detail> queryGoods_detail() {
		Connection conn = DBConnection.getConnection();
		String sql = "select goods_detail.good_id,goods.good_name,goods_category.category_name,goods.sale_price,goods.remaining_count,goods_detail.pic from goods_detail,goods,goods_category where goods_detail.good_id=goods.good_id and goods.category_id=goods_category.category_id";
		Statement stmt = null;
		// System.out.println(sql);
		ResultSet rs = null;
		List<Goods_detail> list = new ArrayList<Goods_detail>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Goods_detail goods_detail = new Goods_detail();
				goods_detail.setGood_id(rs.getInt("good_id"));
				goods_detail.setGoods_name(rs.getString("good_name"));
				goods_detail.setFenlei(rs.getString("category_name"));
				goods_detail.setPrice(rs.getDouble("sale_price"));
				goods_detail.setRemaining(rs.getInt("remaining_count"));
				goods_detail.setPic(rs.getString("pic"));

				list.add(goods_detail);
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
	public boolean deleteGoods_detail(int id) {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from goods_detail where good_id=? ";
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

	@Override
	public boolean updateGoods_detail(int id, Goods_detail gd) {
		Connection conn = DBConnection.getConnection();
		String sql = "update goods_detail.good_id,goods.good_name,goods_category.category_name,goods.cale_price,goods.remaining_count,goods_detail.pic user_realname from goods_detail,goods,goods_category where goods_detail.good_id=goods.goods_id and goods.category_id=goods_category.category_id and goods_detail.good_id=?";
//		Update Table1 set c = (select c from Table2 where a = Table1.a) where c is null
		/**
		 * create proc proc_get_student
			as
    update table1 set field1=updatevalue1 where id=youID1;
    update table2 set field1=updatevalue2 where id=youID2;
		 */
		PreparedStatement pstmt=null;
		
		ResultSet rs = null;
		Goods_detail goods_detail=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			    goods_detail = new Goods_detail();
				goods_detail.setGood_id(rs.getInt("good_id"));
				goods_detail.setGoods_name(rs.getString("good_name"));
				goods_detail.setFenlei(rs.getString("category_name"));
				goods_detail.setPrice(rs.getInt("cale_price"));
				goods_detail.setRemaining(rs.getInt("remaining_count"));
				goods_detail.setPic(rs.getString("pic"));

				
			}
			return true ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			DBConnection.close(conn, pstmt, rs);
		}

	}

	@Override
	public Goods_detail modifyGoods_detail(int id) {
		Connection conn = DBConnection.getConnection();
		String sql = "select goods_detail.good_id,goods.good_name,goods_category.category_name,goods.sale_price,goods.remaining_count,goods_detail.pic  from goods_detail,goods,goods_category where goods_detail.good_id=goods.good_id and goods.category_id=goods_category.category_id and goods_detail.good_id=?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Goods_detail goods_detail=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			    goods_detail = new Goods_detail();
				goods_detail.setGood_id(rs.getInt("good_id"));
				goods_detail.setGoods_name(rs.getString("good_name"));
				goods_detail.setFenlei(rs.getString("category_name"));
				goods_detail.setPrice(rs.getInt("sale_price"));
				goods_detail.setRemaining(rs.getInt("remaining_count"));
				goods_detail.setPic(rs.getString("pic"));

				
			}
			return goods_detail ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {

			DBConnection.close(conn, pstmt, rs);
		}

	}

}
