package com.eshop.model;

public class DataTable {
	private int ID;
	private int minute;
	private String color;
	
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
	
	@Override
	public String toString() {
		return "DataTable [ID=" + ID + ", minute=" + minute + ", color=" + color + "]\n";
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}