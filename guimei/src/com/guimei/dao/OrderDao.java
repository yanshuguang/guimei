package com.guimei.dao;

import java.util.List;

import com.guimei.entity.Order;

public interface OrderDao {
	
	
	public List<Order> selectAllOrder();
	
	public List<Order> selectOrderByIdAndOrdername(int id,String name);
	
	public boolean deleteOrderById(int id);
	
//	public boolean addOrder(Order order);
	
	public boolean updateOrderById(int id,Order order);

	public Order selectOrderById(int id);
	
	
	

}
