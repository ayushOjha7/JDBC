package com.app.jdbc9_CallableStatements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	private static final String SQL = "call getToursByPrice(?);";

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
				CallableStatement stmt = conn.prepareCall(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE,
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
