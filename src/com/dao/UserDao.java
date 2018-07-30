package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.db.DbConnection;


public class UserDao {
	public List<User> selectAll() {
		List<User> list = new ArrayList<User>();
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps = connection.prepareStatement("select * from users");
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_username"));
				user.setPassword(rs.getString("user_password"));
				user.setEmail(rs.getString("user_email"));
				list.add(user);
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
	
	public User login(String userName,String password) {
		User user = null;
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select * from users where user_username=? and user_password=?");
			ps.setString(1,userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_username"));
				user.setPassword(rs.getString("user_password"));
				user.setEmail(rs.getString("user_email"));
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
		return user;
	}
	
	public boolean regist(String userName,String password,String email) {
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into users (user_username,user_password,user_email)value(?,?,?)");
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3,email);
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
	
	public User selectUser(Integer userId) {
		User user = null;
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select * from users where user_id=?");
			ps.setInt(1,userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_username"));
				user.setPassword(rs.getString("user_password"));
				user.setEmail(rs.getString("user_email"));
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
		return user;
	}
	
	public boolean updateUser(Integer userId,String userName,String password,String email) {
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("update users set user_username=?,user_password=?,user_email=? where user_id=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3,email);
			ps.setInt(4, userId);
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
}
