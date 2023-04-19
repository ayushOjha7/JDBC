package com.app.jdbc8_PreparedStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	private static final String SQL = "SELECT tourID, tourName, price FROM tours WHERE price <= ?";

	public static void main(String[] args) throws SQLException {

		double maxPrice;
		try {
			maxPrice = InputHelper.getDoubleInput("Enter Maximum price : ");
		} catch (NumberFormatException e) {
			System.err.println("Error : ");
			return;
		}

		ResultSet rs = null;
		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);) {

			stmt.setDouble(1, maxPrice);
			rs = stmt.executeQuery();
			Tours.displayData(rs);

		} catch (SQLException e) {
			DBUtil.processException(e);
		} finally {
			if (rs != null)
				rs.close();
		}
	}
}
