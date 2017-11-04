package com.srevesz.offer.repository;

import org.springframework.data.repository.CrudRepository;

import com.srevesz.offer.model.Offer;

public interface OfferRepository extends CrudRepository<Offer, Long>{
	Offer save(String goods, String description, Double price, String currency);
}
