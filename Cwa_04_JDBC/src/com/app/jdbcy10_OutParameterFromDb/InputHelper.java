package com.app.jdbcy10_OutParameterFromDb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {

	public static String getInput(String prompt) {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(prompt);
		System.out.flush();
		try {
			return stdin.readLine();
		} catch (Exception e) {
			return "Error : " + e.getMessage();
		}
	}

	public static double getDoubleInput(String prompt) {
		String input = getInput(prompt);
		return Double.parseDouble(input);
	}

}
