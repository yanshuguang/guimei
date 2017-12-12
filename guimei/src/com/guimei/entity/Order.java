package com.guimei.entity;

import java.util.Date;

public class Order {
	
	private int order_id;
	private String order_address;
	private int order_user_id;
	private String user_name;//用户的姓名
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	private double order_sum_price;
	private String order_date;
	private int order_status;
	private int payment_id;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public int getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(int order_user_id) {
		this.order_user_id = order_user_id;
	}
	public double getOrder_sum_price() {
		return order_sum_price;
	}
	public void setOrder_sum_price(double order_sum_price) {
		this.order_sum_price = order_sum_price;
	}
	
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	
	
}
