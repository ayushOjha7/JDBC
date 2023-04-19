package com.app.jdbc7_LimitingRows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT tourId, tourName, price FROM tours" + " LIMIT 5,5");) {

			stmt.setMaxRows(5);

			Tours.displayData(rs);

		} catch (SQLException e) {
			DBUtil.processException(e);
		}
	}
}
