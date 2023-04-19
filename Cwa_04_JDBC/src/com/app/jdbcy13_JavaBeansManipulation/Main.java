package com.app.jdbcy13_JavaBeansManipulation;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		StatesManager.displayAllRows();
		ToursManager.displayAllRows();
		AdminManager.displayAllRows();

	}

}
