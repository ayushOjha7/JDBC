package com.app.jdbcy12_JavaBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminManager {

	private static String SQL = "Select adminId, userName, password from admin";

	public static void displayAllRows() {

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);) {

			System.out.println("Admin Table : ");

			while (rs.next()) {
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("adminId") + " : ");
				bf.append(rs.getString("userName") + " : ");
				bf.append(rs.getString("password") + " : ");
				System.out.println(bf.toString());
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public static Admin getRow(int adminId) throws SQLException {

		String SQL2 = "SELECT userName, password FROM ADMIN where adminID = ?";
		ResultSet rs = null;

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(SQL2);) {
			stmt.setInt(1, adminId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Admin bean = new Admin();
				bean.setAdminId(adminId);
				bean.setUsername(rs.getString("userName"));
				bean.setPassword(rs.getString("password"));
				return bean;
			} else {
				{
					System.err.println("No User found !!!");
					return null;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
