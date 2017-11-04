package com.srevesz.offer.repository;

import com.srevesz.offer.model.Offer;

public interface OfferRepository {
	Offer save(String goods, String description, Double price, String currency);
}
