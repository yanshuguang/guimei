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

public class Goods_categoryUpdateServlet extends HttpServlet {

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
		
		int id=Integer.parseInt(request.getParameter("id"));
		String category_name=request.getParameter("category_name");
		Goods_categoryDao dao = DaoFactory.getGoods_categoryDao();
		
		Goods_category gc=new Goods_category();
		gc.setCategory_name(category_name);
		dao.updateGoods_category(id, gc);
		System.out.println(id+" ---"+category_name);
		
		request.getRequestDispatcher("../page/goods_categorymanage.jsp").forward(request, response);
		
		
	}

}
