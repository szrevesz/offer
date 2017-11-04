package com.srevesz.offer.model;

public class Offer {
	private Long id;
	
	private String goods;
	
	private String description;
	
	private Double price;
	
	private String currency;

	public Offer(String goods, String description, Double price, String currency) {
		this.goods = goods;
		this.description = description;
		this.price = price;
		this.currency = currency;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getGoods() {
		return goods;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getCurrency() {
		return currency;
	}
}
