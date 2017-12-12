package com.guimei.dao;

import java.util.List;

import com.guimei.entity.Login;
import com.guimei.entity.User;

public interface UserDao {
	
//	public boolean login(Login login);
	/**
	 * 注册用户，添加到数据库里
	 * @param user
	 */
	public void regist(User user);
	
	/**
	 *后台添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * 用户登录，获取用户登录的用户信息跟数据库中的比较，相同登录成功，跳转的主页
	 * @param login
	 * @param sql
	 * @return
	 */
	boolean login(Login login, String sql);
	
	/**
	 * 查询数据库中的用户信息，返回list集合
	 * @return
	 */
	public List<User> selectAllUser(int currentPage ,int pageCount );
	
	/**
	 * 获取用户总的记录数
	 * @return
	 */
	public int getUserCount();
	
	/**
	 * 根据用户的id查找并返回用户
	 * @return
	 */
	public User findUserById(int id);
	
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id);
	
	
	/**
	 * 根据id修改用户信息
	 * @param id
	 * @return
	 */
	public boolean updateUser(int id,User user);

}
