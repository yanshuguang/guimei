package com.guimei.controller.goods_category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.guimei.dao.Goods_classDao;
import com.guimei.entity.Goods_class;
import com.guimei.util.DaoFactory;

public class QueryBigClassServlet extends HttpServlet {

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

		Goods_classDao dao = DaoFactory.getGoods_classDao();
		
		Gson gson = new Gson();  
		List<Goods_class> list = dao.queryGoods_class();
		//引入的一个谷歌的一个jar包可以直接把list集合转化为为json 对象
		
		String str = gson.toJson(list); 
		System.out.println(str);
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().print(str);
		
	}

}
