package com.srevesz.offer.service;

import org.springframework.stereotype.Service;

import com.srevesz.offer.model.Offer;

@Service
public class OfferManager {

	public Offer save(String goods, String description, Double price, String currency) {
		Offer offer = new Offer(goods, description, price, currency);
		return offer;
	}
}
