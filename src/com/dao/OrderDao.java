package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Orders;
import com.db.DbConnection;


public class OrderDao {
	public boolean insertIntoOrderAndOrdeDetail(Integer bookId,Integer count,Integer userId,String time) {
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs=null;
		try {
			connection.setAutoCommit(false);
			ps1 = connection.prepareStatement("insert into orders(user_id,order_time)value(?,?)");
			ps1.setInt(1,userId);
			ps1.setString(2,time);
			ps1.execute();
			ps2 = connection.prepareStatement("select order_id from orders where user_id=?");
			ps2.setInt(1, userId);
			rs = ps2.executeQuery();
			while (rs.next()) {
				ps3 = connection.prepareStatement("insert into order_detail(book_id,count,order_id)value(?,?,?)");
				ps3.setInt(1, bookId);
				ps3.setInt(2, count);
				ps3.setInt(3, rs.getInt("order_id"));
				ps3.execute();
			}
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps1.close();
				ps2.close();
				ps3.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Orders> selectOrder() {
		List<Orders> list = new ArrayList<Orders>();
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps = connection.prepareStatement("select * from orders,order_detail where orders.order_id = order_detail.order_id");
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders order = new Orders();
				order = new Orders();
				order.setOrderId(rs.getInt("order_id"));
				order.setOrderDetailId(rs.getInt("order_detail_id"));
				order.setBookId(rs.getInt("book_id"));
				order.setCount(rs.getInt("count"));
				order.setOrderTime(rs.getString("order_time"));
				order.setUserId(rs.getInt("user_id"));
				list.add(order);
				
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
}
