package com.app.jdbcy12_JavaBeans;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		int adminId = InputHelper.getIntegerInput("Enter Admin Id : ");

		Admin bean = AdminManager.getRow(adminId);

		if (bean != null) {
			System.out.println("Name :" + bean.getUsername());
			System.out.println("Password :" + bean.getPassword());
		}

	}

}
