package com.cbl.aa.entity;

import java.io.Serializable;

public class Qunae implements Serializable{

	private Long id;
	private String city;
	private String spot;
	private Long spot_id;
	private Double hot;
	private Double price;
	private int num;
	private String levels;
	private Double avg_price;
	
	public Double getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(Double avg_price) {
		this.avg_price = avg_price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSpot() {
		return spot;
	}
	public void setSpot(String spot) {
		this.spot = spot;
	}
	public Long getSpot_id() {
		return spot_id;
	}
	public void setSpot_id(Long spot_id) {
		this.spot_id = spot_id;
	}
	public Double getHot() {
		return hot;
	}
	public void setHot(Double hot) {
		this.hot = hot;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	@Override
	public String toString() {
		return "Qunae [id=" + id + ", city=" + city + ", spot=" + spot
				+ ", spot_id=" + spot_id + ", hot=" + hot + ", price=" + price
				+ ", num=" + num + ", levels=" + levels + "]";
	}
	
}
