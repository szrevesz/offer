package com.srevesz.offer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srevesz.offer.model.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{
	//Offer save(String goods, String description, Double price, String currency);
}
