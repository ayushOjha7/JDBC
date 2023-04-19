package com.app.jdbcy10_OutParameterFromDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs) throws SQLException {

		rs.last();
		int nRows = rs.getRow();
		if (nRows == 0) {
			System.out.println("No Tours were found");
		} else {
			System.out.println("Number of tours : " + nRows);
			rs.beforeFirst();
		}

		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();

			buffer.append("Tour : " + rs.getInt("tourId"));
			buffer.append(" | Name : " + rs.getString("tourName"));
			Double price = rs.getDouble("price");
			buffer.append(" | Price : " + NumberFormat.getCurrencyInstance().format(price));

			System.out.println(buffer.toString());
		}
	}

	public static void displayData2(ResultSet rs, int nRows) throws SQLException {

		if (nRows == 0) {
			System.out.println("No Tours were found");
		} else {
			System.out.println("Number of tours : " + nRows);
			rs.beforeFirst();
		}

		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();

			buffer.append("Tour : " + rs.getInt("tourId"));
			buffer.append(" | Name : " + rs.getString("tourName"));
			Double price = rs.getDouble("price");
			buffer.append(" | Price : " + NumberFormat.getCurrencyInstance().format(price));

			System.out.println(buffer.toString());
		}
	}

}
