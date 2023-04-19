package com.app.jdbc7_LimitingRows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

		ResultSet rs = null;
		// Try - With Resources

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {

			stmt.setMaxRows(5);
			rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours");
			Tours.displayData(rs);

		} catch (SQLException e) {
			DBUtil.processException(e);
		}
	}
}
//// fetches whole table and then filters the rows . not very good .