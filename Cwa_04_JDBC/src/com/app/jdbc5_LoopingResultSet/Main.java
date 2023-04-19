package com.app.jdbc5_LoopingResultSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

		//Try - With Resources
		
		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM tours");) {


			Tours.displayData(rs);

		} catch (SQLException e) {
			DBUtil.processException(e);
		}
	}
}
