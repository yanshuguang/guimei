package com.guimei.dao;

import java.util.List;

import com.guimei.entity.Announcement;

public interface AnnouncementDao {
	/**
	 * 查询所有公告内容，返回一个list集合
	 * @return
	 */
	public List<Announcement> queryAllAnnouncement();
	
	/**
	 * 根据id返回一个公告对象
	 * @return
	 */
	public Announcement selectAnnouncementById(int id);
	
	/**
	 * 根据id删除一条公告
	 * @param id
	 */
	public void deleteAnnouncementById(int id);
	
	/**
	 * 根据id修改公告内容
	 * @param id
	 */
	public void updateAnnouncement(int id ,Announcement ann);
	
	/**
	 * 
	 * @param ann
	 * @return
	 */
	public boolean addAnnouncement(Announcement ann);

}
