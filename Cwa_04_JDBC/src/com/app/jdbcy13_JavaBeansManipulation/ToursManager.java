package com.app.jdbcy13_JavaBeansManipulation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

public class ToursManager {

	private static String SQL = "Select tourId, tourName, price from tours";

	public static void displayAllRows() {

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);) {

			System.out.println("Tours Table : ");

			while (rs.next()) {
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("tourId") + " : ");
				bf.append(rs.getString("tourName") + " : ");

				Double price = rs.getDouble("price");
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String formattedPrice = nf.format(price);
				bf.append(" ( " + formattedPrice + " ) ");
				System.out.println(bf.toString());
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
