package com.eshop.model;

public class DataTable {
	private int ID;
	private int minute;
	private String color;
	
	@Override
	public String toString() {
		return "<tr><td> " + ID + " </td> <td> " + minute + " </td><td> " + color + " </td></tr>";
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}