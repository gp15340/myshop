package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;

/**
 * Servlet implementation class AlterBookServlet
 */
@WebServlet("/AlterBookServlet")
public class AlterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String typeName = request.getParameter("typeName");
		Double price = Double.parseDouble(request.getParameter("price"));
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		BookDao bookDao = new BookDao();
		boolean flag = bookDao.alterBook(bookId,bookName,typeName,price,author,publisher);
		if (flag) {
			response.sendRedirect("updateRespond.jsp");
		} else {
			request.setAttribute("errorMsg", "失败");
			request.getRequestDispatcher("updateRespond.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
