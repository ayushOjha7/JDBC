package com.app.jdbc1_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_01_GettingConnnection {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

	public static void main(String[] args) throws SQLException {

//		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected ...");
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

}
