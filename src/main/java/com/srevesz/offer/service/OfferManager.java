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
		Offer offer = new Offer(goods, description, price, currency);
		return offerRepository.save(offer);
	}
	
	public Offer update(Long id, String goods, String description, Double price, String currency) {
		Offer offer = offerRepository.findOne(id);
		if (offer != null) {
			offer.setGoods(goods);
			offer.setDescription(description);
			offer.setPrice(price);
			offer.setCurrency(currency);
			
			offer = offerRepository.save(offer);
		}
		return offer;
	}
	
	public void delete(Long id) {
		//TODO
	}
	
	public Offer find(Long id) {
		//TODO
		return null;
	}
	
	public Iterable<Offer> findAll() {
		//TODO
		return null;
	}
}
