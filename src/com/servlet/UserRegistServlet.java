package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String email = request.getParameter("email");
		
		UserDao userDao = new UserDao();
		if (rePassword.equals(password)) {
			boolean flag = userDao.regist(userName,password,email);
			if ( rePassword.equals(password) && flag) {
				response.sendRedirect("userRegistSuccess.jsp");
			} else {
				request.setAttribute("errorMsg", "注册失败");
				request.getRequestDispatcher("userRegist.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMsg", "注册失败");
			request.getRequestDispatcher("userRegist.jsp").forward(request, response);
		}
	}

}
