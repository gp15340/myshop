package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.bean.Page;
import com.service.BookService;

/**
 * Servlet implementation class AdminSelectServlet
 */
@WebServlet("/AdminSelectServlet")
public class AdminSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BookService bookService = new BookService();
		List<Book> list = bookService.getBooks();
		
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
		List<Book> bookList = list.subList((dpage-1)*page.getPagecount(), end);
		request.setAttribute("page", page);
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("frame_right.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
