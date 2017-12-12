package com.guimei.dao;

import java.util.List;

import com.guimei.entity.Goods_detail;

public interface Goods_detailDao {
	
	public List<Goods_detail> queryGoods_detail();
	
	
	public boolean deleteGoods_detail(int id);
	
	public boolean updateGoods_detail(int id,Goods_detail gd);
	
	public Goods_detail modifyGoods_detail(int id);

}
