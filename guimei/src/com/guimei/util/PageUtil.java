package com.guimei.util;
/**
 * 分页的工具类
 * Administrator
 * 2017年5月11日
 */
public class PageUtil {
	public PageUtil(int rows,int pageCount,int currentPage){
		this.rows = rows;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
		//初始化总页数
		this.setTotalPage();
	}
	
	//每一页的记录数
	private int pageCount;
	//当前页
	private int currentPage;
	//总记录数
	private int rows;
	//当前记录
	private int currentCount;
	//总页数
	private int totalPage;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		totalPage = (int)(Math.ceil(1.0 * rows/pageCount));
	}
	
	public String getLink(String url){
		StringBuffer sb = new StringBuffer();
		if(currentPage == 1){
			sb.append("<b>首页</b>");
		}else{
			sb.append("<a href='"+url+"?currentPage=1'>首页</a>");
		}
		if(currentPage <= 1){
			currentPage = 1;
			sb.append("上一页");
		}else{
			sb.append("<a href='"+url+"?currentPage="+(currentPage - 1)+"'>上一页</a>");
		}
		sb.append("&nbsp;&nbsp;");
		
		for (int i = 1; i <= this.totalPage ; i++) {
			if(currentPage == i){
				sb.append("<b>"+i+"</b>");
				sb.append("&nbsp;&nbsp;");
			}else{
				sb.append("<a href='"+url+"?currentPage="+i+"'>"+i+"</a>" );
				sb.append("&nbsp;&nbsp;");
			}
		}
		sb.append("&nbsp;&nbsp;");
		if(currentPage >= this.totalPage){
			currentPage = this.totalPage;
			sb.append("下一页");
		}else{
			sb.append("<a href='"+url+"?currentPage="+(currentPage + 1)+"'>下一页</a>");
		}
		if(currentPage == totalPage){
			sb.append("<b>尾页</b>");
		}else{
			sb.append("<a href='"+url+"?currentPage="+totalPage+"'>尾页</a>");
		}
		return sb.toString();
	}
	
}
