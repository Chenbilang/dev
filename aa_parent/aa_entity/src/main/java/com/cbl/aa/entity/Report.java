package com.cbl.aa.entity;
public class Report {

	private String name;
	private int y;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Report(String name, int y) {
		super();
		this.name = name;
		this.y = y;
	}
	

	
}
