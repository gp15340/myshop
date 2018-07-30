package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
		String bookName = request.getParameter("bookName");
		String typeName = request.getParameter("typeName");
		Double price = Double.parseDouble(request.getParameter("price"));
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		BookDao bookDao = new BookDao();
		boolean flag = bookDao.addBook(bookName,typeName,price,author,publisher);
		if (flag) {
			response.sendRedirect("AdminSelectServlet");
		} else {
			request.setAttribute("errorMsg", "失败");
			request.getRequestDispatcher("addBook.jsp").forward(request, response);
		}
	}
	

}
