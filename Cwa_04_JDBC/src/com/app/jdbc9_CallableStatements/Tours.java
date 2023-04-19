package com.app.jdbc9_CallableStatements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs) throws SQLException {

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

}
