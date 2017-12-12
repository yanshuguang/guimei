package com.guimei.controller.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guimei.dao.OrderDao;
import com.guimei.entity.Order;
import com.guimei.util.DaoFactory;

public class OrderUpdateServlet extends HttpServlet {

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
		
		String s=request.getParameter("id");
		int id=Integer.parseInt(s);
		
		OrderDao dao =DaoFactory.getOrderDao();
		
		String sorder_id=request.getParameter("order_id");
		int order_id=Integer.parseInt(sorder_id.trim());
		String order_name=request.getParameter("order_name");
		String order_address=request.getParameter("order_address");
		String order_total=request.getParameter("order_total");
		double d_total=Double.parseDouble(order_total);
		String order_date=request.getParameter("order_date");
		String orderrs=request.getParameter("order_status");
//		System.out.println(orderrs);
//		System.out.println(d_total);
		int order_status = 0;
		if(orderrs.equals("待审核")){
			order_status=1;
		}else if(orderrs.equals("已确认")){
			order_status=2;
		}
		
		
		Order order=new Order();
		order.setOrder_id(order_id);
		order.setOrder_address(order_address);
		order.setUser_name(order_name);
		order.setOrder_sum_price(d_total);
		order.setOrder_date(order_date);
//		order.setOrder_status(order_status);
		order.setOrder_status(order_status);
		
		
		dao.updateOrderById(id,order);
		
		request.setAttribute("orders",dao.selectAllOrder() );
		
		request.getRequestDispatcher("../page/ordermanage.jsp").forward(request, response);
				
	}

}
