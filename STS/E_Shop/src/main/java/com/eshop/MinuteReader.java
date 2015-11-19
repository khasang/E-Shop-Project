package com.eshop;

import java.io.InputStream;
import java.util.Scanner;

public class MinuteReader {
	private Scanner inputFromUser;
	private static int userInputNumber;

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
			System.out.println(Text.ENTER_NUMBER);
			inputFromUser = new Scanner(is);
			userInputNumber = Integer.parseInt(inputFromUser.nextLine());
		} catch (Exception e) {
			System.err.println(Text.WRONG_FORMAT);
		}
	}

	public boolean isNumberRangeTrue(int numberToCheck) {
		return (numberToCheck > 0 && numberToCheck < 59);
	}

	public static int getUserInputNumber(){
		return userInputNumber;
	}
}
