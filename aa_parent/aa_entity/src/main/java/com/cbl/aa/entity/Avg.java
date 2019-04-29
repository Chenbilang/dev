package com.cbl.aa.entity;
public class Avg {

	private String name;
	private Double value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Avg(String name, Double value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	

	
}
