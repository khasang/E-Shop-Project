package com.eshop.tests;

import com.eshop.model.TempClass;

public class TestTempClass {
	public static void main(String[] args){
		TestTempClass tmp =  new TestTempClass();
		tmp.testTempClass();
		Assert.assertEquals(true, tmp.testNumeration(1, 0));
		Assert.assertEquals(false, tmp.testNumeration(0, 0));
		Assert.assertEquals(false, tmp.testNumeration(0, 1));
	}

	public void testTempClass() {
		@SuppressWarnings("unused")
		boolean testTempClassResult;
		TempClass tmp = new TempClass();
		if (4 == tmp.sqrMethod(2, 2)) {
			testTempClassResult = true;
			System.out.println("Success");
		} else {
			System.out.println("false");
		}
	}
	
	public boolean testNumeration(double x, double y){
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
