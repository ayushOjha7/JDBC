package com.app.jdbc2_MultiDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainMySql {


	public static void main(String[] args) throws SQLException {

//		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
//			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM states");

			rs.last();
			System.out.println("Number of rows : " + rs.getRow());

//		System.out.println("Connected ...");
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
