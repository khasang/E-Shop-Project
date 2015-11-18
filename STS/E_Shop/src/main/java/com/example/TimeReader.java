package com.example;

import java.util.Scanner;

abstract public class TimeReader {
	private static int minute;
	Scanner inputInfoMinutesFromUser;

	public static int getMinute() {
		return minute;
	}

	void resultColorOut() {
		MinuteReader reader = new MinuteReader();
		System.out.println(reader.outputColor());
	}
	/*
	 * try { inputInfoMinutesFromUser = new Scanner(System.in);
	 * System.out.println("Enter a number from 0 to 59"); minute =
	 * Integer.parseInt(inputInfoMinutesFromUser.nextLine()); while (minute > 59
	 * || minute < 0) { System.out.println("Re-enter a number from 0 to 59");
	 * minute = Integer.parseInt(inputInfoMinutesFromUser.nextLine()); }
	 * System.out.println("Check localhost:8080/result"); } catch
	 * (NumberFormatException e) { System.err.println("Wrong format!"); }
	 * finally { if (inputInfoMinutesFromUser != null)
	 * inputInfoMinutesFromUser.close(); }
	 */

}
