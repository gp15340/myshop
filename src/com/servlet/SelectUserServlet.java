package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Page;
import com.bean.User;
import com.dao.UserDao;

/**
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDao userDao = new UserDao();
		List<User> list = userDao.selectAll();
		
		String pageS = request.getParameter("page");
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
		List<User> userList = list.subList((dpage-1)*page.getPagecount(), end);
		request.setAttribute("page", page);
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("checkUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
