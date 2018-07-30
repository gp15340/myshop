package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Orders;
import com.bean.Page;
import com.dao.OrderDao;

/**
 * Servlet implementation class SelectOrderServlet
 */
@WebServlet("/SelectOrderServlet")
public class SelectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		OrderDao orderDao = new OrderDao();
		List<Orders> list = orderDao.selectOrder();
		
		String pageS = request.getParameter("page");//null
		Integer dpage=1;
		if(pageS!=null) {
			dpage=Integer.parseInt(pageS);
		}
		Page page = new Page();
		page.setTotalcount(list.size());
		page.setTotalpage();
		page.setDpage(dpage);
		Integer end=dpage*page.getPagecount();
		if(end>page.getTotalcount()) {
			end=page.getTotalcount();
		}
		List<Orders> orderList = list.subList((dpage-1)*page.getPagecount(), end);
		request.setAttribute("page", page);
		
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("checkOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
