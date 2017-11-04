package com.srevesz.offer.service;

import org.springframework.stereotype.Service;

import com.srevesz.offer.model.Offer;
import com.srevesz.offer.repository.OfferRepository;

@Service
public class OfferManager {

	private OfferRepository offerRepository;
	
	public OfferManager(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	public Offer save(String goods, String description, Double price, String currency) {
		return offerRepository.save(goods, description, price, currency);
	}
}
