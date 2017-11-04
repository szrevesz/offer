package com.srevesz.offer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.srevesz.offer.model.Offer;
import com.srevesz.offer.repository.OfferRepository;

@RunWith(MockitoJUnitRunner.class)
public class OfferManagerTest {

	private static final String GOODS = "Coffee Machine";
	private static final String DESCRIPTION = "Best offer ever, buy me now";
	private static final Double PRICE = 99.99;
	private static final String CURRENCY = "GBP";
	
	private static final Offer OFFER = new Offer(GOODS, DESCRIPTION, PRICE, CURRENCY);
	
	private OfferManager offerManager;
	
	@Mock
	OfferRepository offerRepository;
	
	@Before
	public void init() {
		offerManager = new OfferManager(offerRepository);
	}
	
	@Test
	public void saveOffer() {
		//mocking the repository
		when(offerRepository.save(GOODS, DESCRIPTION, PRICE, CURRENCY)).thenReturn(OFFER);
		
		Offer offer = offerManager.save(GOODS, DESCRIPTION, PRICE, CURRENCY);
		
		assertThat(GOODS.equals(offer.getGoods()));
		assertThat(DESCRIPTION.equals(offer.getDescription()));
		assertThat(PRICE == offer.getPrice());
		assertThat(CURRENCY.equals(offer.getCurrency()));
	}
}
