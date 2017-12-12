package com.guimei.controller.goods_category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.Goods_categoryDao;
import com.guimei.entity.Goods_category;
import com.guimei.util.DaoFactory;

public class Goods_categoryModifyServlet extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		String s = request.getParameter("id");
		
		int id=Integer.parseInt(s);
		
		Goods_categoryDao dao = DaoFactory.getGoods_categoryDao();
		Goods_category gd = dao.modifyGoods_category(id);
//		System.out.println(gd);
		request.setAttribute("gc", gd);
		request.getRequestDispatcher("../page/goods_categorymodify.jsp").forward(request, response);
		
	}

}
