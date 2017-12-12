package com.guimei.entity;

public class Goods { 
	private int good_id;
	private String good_name;
	private int category_id;
	private String picture;
	private double sale_price;
	private int remaining_count;
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public int getRemaining_count() {
		return remaining_count;
	}
	public void setRemaining_count(int remaining_count) {
		this.remaining_count = remaining_count;
	}
	
	

}
