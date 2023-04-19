package com.app.jdbc6_Scrollable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

		// Try - With Resources

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT stateId,stateName FROM states");) {

			rs.last();
			System.out.println("Total States : " + rs.getRow());
			rs.first();
			System.out.println("First State : " + rs.getString("stateName"));
			rs.last();
			System.out.println("Last State : " + rs.getString("stateName"));
			rs.absolute(10);
			System.out.println("10th State : " + rs.getString("stateName"));
			
			System.out.println("==============================");
			
			rs.beforeFirst();
			States.displayData(rs);

		} catch (SQLException e) {
			DBUtil.processException(e);
		}
	}
}
