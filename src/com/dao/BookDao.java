package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.bean.BookType;
import com.db.DbConnection;

public class BookDao {

	public List<Book> selectAll() {
		List<Book> list = new ArrayList<Book>();
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps = connection.prepareStatement("select * from book,book_type where book.type_id=book_type.type_id");
			rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setPrice(rs.getDouble("book_price"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setImgUrl(rs.getString("book_imgurl"));
				BookType bookType = new BookType();
				bookType.setTypeId(rs.getInt("type_id"));
				bookType.setTypeName(rs.getString("type_name"));
				book.setBookType(bookType);
				list.add(book);
			} 
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
				try {
					rs.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}

	public boolean addBook(String bookName,String typeName,Double price,String author,String publisher ) {
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into book(type_id,book_name,book_price,book_author,book_publisher)value((select type_id from book_type where type_name=?),?,?,?,?)");
			ps.setString(1,typeName);
			ps.setString(2,bookName);
			ps.setDouble(3,price);
			ps.setString(4,author);
			ps.setString(5,publisher);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean dropBook(int bookId) {
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("delete from book where book_id = ?");
			ps.setInt(1, bookId);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean alterBook(Integer bookId,String bookName,String typeName,Double price,String author,String publisher) {
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("update book set book_name=?,type_id=(select type_id from book_type where type_name=?),book_price=?,book_author=?,booK_publisher=? where book_id=?");
			ps.setString(1, bookName);
			ps.setString(2, typeName);
			ps.setDouble(3,price);
			ps.setString(4,author);
			ps.setString(5, publisher);
			ps.setInt(6, bookId);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Book selectOneBook(Integer bookId) {
		Connection connection = DbConnection.getConnection();
		Book book = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps = connection.prepareStatement("select * from book,book_type where book.type_id=book_type.type_id && book_id=?");
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setPrice(rs.getDouble("book_price"));
				book.setAuthor(rs.getString("book_author"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setImgUrl(rs.getString("book_imgurl"));
				BookType bookType = new BookType();
				bookType.setTypeId(rs.getInt("type_id"));
				bookType.setTypeName(rs.getString("type_name"));
				book.setBookType(bookType);
			} 
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
				try {
					rs.close();
					ps.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return book;
	}
}

