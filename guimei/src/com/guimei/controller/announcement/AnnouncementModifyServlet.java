package com.guimei.controller.announcement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.AnnouncementDao;
import com.guimei.entity.Announcement;
import com.guimei.util.DaoFactory;

public class AnnouncementModifyServlet extends HttpServlet {

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

//		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		String s=request.getParameter("id");
		int id=Integer.parseInt(s);
		
		AnnouncementDao dao=DaoFactory.getAnnouncementDao();
		
		 Announcement ann=dao.selectAnnouncementById(id);
		 request.setAttribute("ann", ann);
		 request.getRequestDispatcher("../page/announcementmodify.jsp").forward(request,
					response);
	}

}
