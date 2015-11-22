package com.eshop;

import java.util.Scanner;

public class TimeReader {
	Integer minute;

	public int getMinute() {
		getDataFromUser();
		return minute;
	}

	public void getDataFromUser() {
		try (Scanner inputInfoMinutesFromUser = new Scanner(System.in)) {
			System.out.println("Enter a number from 0 to 59");
			minute = Integer.parseInt(inputInfoMinutesFromUser.nextLine());
			while (minute > 59 || minute < 0) {
				System.out.println("Re-enter a number from 0 to 59");
				minute = Integer.parseInt(inputInfoMinutesFromUser.nextLine());
			}
			System.out.println("Check localhost:8080/result");
		} catch (NumberFormatException e) {
			System.err.println("Wrong format!");
		}
	}

}
