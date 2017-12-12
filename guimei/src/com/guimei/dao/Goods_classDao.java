package com.guimei.dao;

import java.util.List;

import com.guimei.entity.Goods_class;

public interface Goods_classDao {
	
	public List<Goods_class> queryGoods_class();
	
	public boolean deleteGoods_class(int id);
	
	public boolean updateGoods_class(Goods_class gs,int id);
	
	public boolean addGoods_class(Goods_class gs);
	
	public Goods_class selectById(int id);
	
	public boolean queryGooods_classByName(String name);

}
