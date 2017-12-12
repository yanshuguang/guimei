package com.guimei.controller.announcement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.AnnouncementDao;
import com.guimei.entity.Announcement;
import com.guimei.util.DaoFactory;

public class AnnouncementAddServlet extends HttpServlet {


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
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Announcement ann=new Announcement();
		ann.setTitle(title);
		ann.setContent(content);
		AnnouncementDao dao=DaoFactory.getAnnouncementDao();
		
		dao.addAnnouncement(ann);
		
		
		request.setAttribute("anns", dao.queryAllAnnouncement());
		
		
		request.getRequestDispatcher("../page/announcementmanage.jsp").forward(request,
				response);
		
		
	}

	
}
