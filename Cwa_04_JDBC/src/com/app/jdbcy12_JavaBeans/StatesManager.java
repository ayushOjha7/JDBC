package com.app.jdbcy12_JavaBeans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatesManager {

	private static String SQL = "Select stateId, stateName from states";

	public static void displayAllRows() {

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);) {

			System.out.println("States Table : ");

			while (rs.next()) {
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getString("stateId") + " : ");
				bf.append(rs.getString("stateName") + " : ");
				System.out.println(bf.toString());
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
