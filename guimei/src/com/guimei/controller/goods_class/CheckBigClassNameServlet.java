package com.guimei.controller.goods_class;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.Goods_classDao;
import com.guimei.util.DaoFactory;

public class CheckBigClassNameServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String classname=request.getParameter("classname");
		
		Goods_classDao dao = DaoFactory.getGoods_classDao();
		
		boolean flag = dao.queryGooods_classByName(classname);
		if(flag){
			request.setAttribute("message", "分类已存在！");
		}else if(classname==null){
			request.setAttribute("message", "请输入新的分类！");
		}else{
			request.setAttribute("message", "输入合法！");
		}
	}

}
