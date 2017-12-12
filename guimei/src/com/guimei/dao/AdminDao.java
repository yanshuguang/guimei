package com.guimei.dao;

public interface AdminDao {
	
	public boolean login(String user,String password);
	
	public boolean regist(String user,String password);

}
