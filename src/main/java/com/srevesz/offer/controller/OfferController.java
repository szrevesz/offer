package com.srevesz.offer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srevesz.offer.model.Offer;
import com.srevesz.offer.service.OfferManager;

@RestController
public class OfferController {
	
	private OfferManager offerManager;

	public OfferController(OfferManager offerManager) {
		this.offerManager = offerManager;
	}
	
	@RequestMapping(value="/api/offer", method = RequestMethod.POST)
	public Offer create(
			@RequestParam("goods") String goods,
			@RequestParam("description") String description,
			@RequestParam("price") Double price,
			@RequestParam("currency") String currency
	) {
		Offer offer = offerManager.save(goods, description, price, currency);
		return offer;
	}
	
	@RequestMapping(value="/api/offer", method = RequestMethod.PUT)
	public Offer update(
			@RequestParam("id") Long id,
			@RequestParam("goods") String goods,
			@RequestParam("description") String description,
			@RequestParam("price") Double price,
			@RequestParam("currency") String currency
	) {
		Offer offer = offerManager.update(id,goods, description, price, currency);
		return offer;
	}
	
	@RequestMapping(value="/api/offer/{id}", method = RequestMethod.DELETE)
	public void deleteOffer(
			@PathVariable("id") Long id
	) {
		offerManager.delete(id);
	}
	
	@RequestMapping(value="/api/offer/{id}", method = RequestMethod.GET)
	public Offer find(
			@PathVariable("id") Long id
	) {
		return offerManager.find(id);
	}
	
	@RequestMapping(value="/api/offers", method = RequestMethod.GET)
	public Iterable<Offer> findAll() {
		return offerManager.findAll();
	}

}