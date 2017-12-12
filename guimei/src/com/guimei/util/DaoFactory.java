package com.guimei.util;

import com.guimei.dao.AdminDao;
import com.guimei.dao.AnnouncementDao;
import com.guimei.dao.Goods_categoryDao;
import com.guimei.dao.Goods_classDao;
import com.guimei.dao.Goods_detailDao;
import com.guimei.dao.OrderDao;
import com.guimei.dao.UserDao;
import com.guimei.dao.impl.AdminDaoImpl;
import com.guimei.dao.impl.AnnouncementDaoImpl;
import com.guimei.dao.impl.Goods_categoryDaoImpl;
import com.guimei.dao.impl.Goods_classDaoImpl;
import com.guimei.dao.impl.Goods_detailDaoImpl;
import com.guimei.dao.impl.OrderDaoImpl;
import com.guimei.dao.impl.UserDaoImpl;
import com.guimei.entity.Announcement;

public class DaoFactory {
	
	public static UserDao getUserDao(){
		return new UserDaoImpl();
		
	}
	public static AnnouncementDao getAnnouncementDao(){
		
		
		return new AnnouncementDaoImpl();
	}
	/*public static Goods_classDao getGoods_classDao() {
		// TODO Auto-generated method stub
		return new Goods_classDaoImpl();
	}*/
	public static OrderDao getOrderDao() {
		return new OrderDaoImpl();
	}
	public static Goods_classDao getGoods_classDao() {
		// TODO Auto-generated method stub
		return new Goods_classDaoImpl();
	}
	public static AdminDao getAdminDao() {
		// TODO Auto-generated method stub
		return new AdminDaoImpl();
	}
	public static Goods_categoryDao getGoods_categoryDao() {
		// TODO Auto-generated method stub
		return new Goods_categoryDaoImpl();
	}
	public static Goods_detailDao getGoods_detailDao(){
		return new Goods_detailDaoImpl();
	}
}
