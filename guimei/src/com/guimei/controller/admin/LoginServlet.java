package com.guimei.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.AdminDao;
import com.guimei.entity.Login;
import com.guimei.util.DaoFactory;

public class LoginServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("login_name");
		String password=request.getParameter("login_password");
		//输入的验证码
		String checkimg=request.getParameter("checkimg");
		//从checkimage中获取生成的验证码
		String validate=(String)request.getSession().getAttribute("validate");
//		System.out.println(validate);
		Login l=new Login();
		
		AdminDao dao=DaoFactory.getAdminDao();
		
		boolean bool=dao.login(username, password);
//		System.out.println(username);
//		System.out.println(password);
		if(bool&&checkimg.equalsIgnoreCase(validate)){
			l.setUsername(username);
			l.setPassword(password);
			
			request.getSession().setAttribute("login", l);
		}
		response.sendRedirect("./page/index.jsp");
	}

}
