package com.guimei.dao;

import java.util.List;

import com.guimei.entity.Goods_category;

public interface Goods_categoryDao {

	public List<Goods_category> queryGoods_category(int currentPage ,int pageCount) ;
	
	public boolean deleteGoods_category(int id);
	
	public boolean updateGoods_category(int id ,Goods_category gc);
	
	public Goods_category modifyGoods_category(int id);
	
	public boolean addGoods_category(Goods_category gc);
	
	public int getGoods_categoryCount();
}
