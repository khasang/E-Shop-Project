package com.eshop;

import java.util.Scanner;

abstract public class TimeReader {	
	private static int minute;
	
	public static int getMinute() {
		try(Scanner inputMinutes = new Scanner(System.in)) {
			System.out.println(Messages.ENTER_NUMBER);		
			minute = inputMinutes.nextInt();
			while (minute > 59 || minute < 0) {
				System.out.println(Messages.REENTER_NUMBER);
				minute = inputMinutes.nextInt();
			}			
			System.out.println(Messages.CHECK_LOCALHOST);
		}
		return minute;
	} 
}
