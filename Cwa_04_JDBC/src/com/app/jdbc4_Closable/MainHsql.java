package com.app.jdbc4_Closable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainHsql {

	public static void main(String[] args) throws SQLException {

		//Try - With Resources
		
		try (Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT stateIdi,stateName FROM states");) {

			rs.last();
			System.out.println("Number of rows : " + rs.getRow());

		} catch (SQLException e) {
			DBUtil.processException(e);
		}
	}
}
