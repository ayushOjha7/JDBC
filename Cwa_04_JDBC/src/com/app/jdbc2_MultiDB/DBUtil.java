package com.app.jdbc2_MultiDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
	private static final String H_CONN_STRING = "jdbc:mysql:data/explorecalifornia";

	public static Connection getConnection(DBType dbType) throws SQLException {

		switch (dbType) {
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);

		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
		default:
			return null;
		}
	}
}
