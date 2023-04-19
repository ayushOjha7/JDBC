package com.app.jdbcy10_OutParameterFromDb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class Main {

	private static final String SQL = "call GetToursWithCountByPrice(?,?);";

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
			stmt.registerOutParameter(2, Types.INTEGER);
			rs = stmt.executeQuery();
			int nRows = stmt.getInt(2);
			
			Tours.displayData2(rs, nRows);

		} catch (SQLException e) {
			DBUtil.processException(e);
		} finally {
			if (rs != null)
				rs.close();
		}
	}
}
