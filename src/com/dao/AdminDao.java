package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;
import com.db.DbConnection;


public class AdminDao {
	public Admin login(String adminName,String password) {
		Admin admin = null;
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select * from admin where admin_username=? and admin_password=?");
			ps.setString(1,adminName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminName(rs.getString("admin_username"));
				admin.setPassword(rs.getString("admin_password"));
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
		return admin;
	}
}
