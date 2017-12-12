package com.guimei.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.UserDao;
import com.guimei.entity.User;
import com.guimei.util.DaoFactory;
import com.guimei.util.PageUtil;

public class UserDeleteServlet extends HttpServlet {

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

		//response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		UserDao dao=DaoFactory.getUserDao();
		String s1=request.getParameter("id");
		//System.out.println(s);
		int id=Integer.parseInt(s1);
		String s = request.getParameter("currentPage");
		int currentPage = 0;
		if(s != null){
			//如果传了参数，则转换为整数
			currentPage = Integer.parseInt(s);
		}else{
			//如果没有传参数页码，则默认为第一页
			currentPage = 1;
		}
		//默认每一页显示3条数据
		int pageCount = 3;
		
		dao.deleteUser(id);
		
		List<User> users=dao.selectAllUser(currentPage,pageCount);
		//获取user的记录数
		int rows = dao.getUserCount();
		PageUtil pu = new PageUtil(rows,pageCount,currentPage);
		request.getSession().setAttribute("page", pu);
		
		//把所有的user都放到（Session）会话对象中
		request.getSession().setAttribute("users",users);
		
//		List<User> list=dao.selectAllUser();
//		
//		request.setAttribute("users", list);
		
		request.getRequestDispatcher("../page/usermanage.jsp").forward(request, response);
		
		
		
	}

}
