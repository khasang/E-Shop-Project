package com.eshop.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TempClass {
	public double sqrMethod(double x, double y){
		return x*y;
	}
	
	public int inputWord() throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in = reader.readLine();
		return Integer.parseInt(in);
	}
	
	public boolean numeration(double x, double y){
		if(x > y){
			return true;
		}
		else if(x < y){
			return false;
		}
		else if(x == y){
			return false;
		}
		else{
			return false;	
		}
	}
}
