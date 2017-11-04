package com.srevesz.offer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {
	@Id
	@GeneratedValue
	private Long id;
	
	private String goods;

	private String description;
	
	private Double price;
	
	private String currency;

	public Offer() {
		// default constructor
	}
	
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

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
