package com.eshop;

import java.util.Scanner;

public class MinuteReader {
	private Scanner inputFromUser;
	private int userInputNumber;

	public MinuteReader() {
		minuteReaderCyclie();
	}
	
	public void minuteReaderCyclie(){
		while (true) {
			if (isNumberRangeTrue(userInputNumber)){
				break;
			}
		}
	}

	public void readNumberFromConsole() {
		try {
			inputFromUser = new Scanner(System.in);
			userInputNumber = Integer.parseInt(inputFromUser.nextLine());
		} catch (Exception e) {
			System.out.println("Wrong format");
		}
	}

	public boolean isNumberRangeTrue(int numberToCheck) {
		if (numberToCheck > 0 && numberToCheck < 59) {
			return true;
		}
		return false;
	}

	public int getUserInputNumber(){
		return userInputNumber;
	}
}
