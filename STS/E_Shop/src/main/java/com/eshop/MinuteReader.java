package com.eshop;

import java.io.InputStream;
import java.util.Scanner;

public class MinuteReader {
	private Scanner inputFromUser;
	private int userInputNumber;

	public MinuteReader() {
		minuteReaderCyclie();
	}
	
	public void minuteReaderCyclie(){
		while (true) {
			readNumberFromConsole(System.in);
			if (isNumberRangeTrue(userInputNumber)){
				System.out.println("Check localhost:8080/result");
				break;
			}
		}
	}

	public void readNumberFromConsole(InputStream is) {
		try {
			System.out.println("Enter the number of minute");
			inputFromUser = new Scanner(is);
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
