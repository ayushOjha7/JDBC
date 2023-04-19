package com.app.jdbcy13_JavaBeansManipulation;

import java.sql.Connection;
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

}
