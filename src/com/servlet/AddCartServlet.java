package com.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.dao.BookDao;
import com.bean.ShoppingCart;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		request.setAttribute("bookId", bookId);
		HttpSession session = request.getSession();
		Integer count = Integer.parseInt(request.getParameter("count"));
		ArrayList<ShoppingCart>  cartList = (ArrayList<ShoppingCart>)session.getAttribute("cartList");
		Double totalAmount = (Double) session.getAttribute("totalAmount");
		BookDao bookDao = new BookDao(); 
		BigDecimal big = null;
		if (cartList == null) {
			totalAmount = (double) 0;
			big = new BigDecimal(totalAmount);
			cartList = new ArrayList<ShoppingCart>();
			Book book = bookDao.selectOneBook(bookId);
			ShoppingCart cart = new ShoppingCart();
			cart.setBookId(book.getBookId());
			cart.setBookName(book.getBookName());
			cart.setPrice(book.getPrice());
			cart.setCount(count);
			cart.setAmount();
			totalAmount = big.add(cart.getAmount()).doubleValue();
			cartList.add(cart);				
		} else {
			Book book = bookDao.selectOneBook(bookId);
			ShoppingCart cart = new ShoppingCart();
			big = new BigDecimal(totalAmount);
			cart.setBookId(book.getBookId());
			cart.setBookName(book.getBookName());
			cart.setPrice(book.getPrice());
			cart.setCount(count);
			cart.setAmount();
			totalAmount = big.add(cart.getAmount()).doubleValue();
			cartList.add(cart);
		}
		request.getSession().setAttribute("totalAmount", totalAmount);
		request.getSession().setAttribute("cartList", cartList);
		request.getRequestDispatcher("ShowCartServlet").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
