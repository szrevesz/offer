package com.srevesz.offer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
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

	private static final Long ID = 1234L;
	private static final String GOODS = "Coffee Machine";
	private static final String DESCRIPTION = "Best offer ever, buy me now";
	private static final Double PRICE = 99.99;
	private static final String CURRENCY = "GBP";
	
	private static final String GOODS_UPDATED = "Coffee Machine 2.0";
	private static final String DESCRIPTION_UPDATED = "Best offer ever, buy me now!!!";
	private static final Double PRICE_UPDATED = 89.99;
	private static final String CURRENCY_UPDATED = "EUR";
	
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
		when(offerRepository.save(any(Offer.class))).thenReturn(OFFER);
		
		Offer offer = offerManager.save(GOODS, DESCRIPTION, PRICE, CURRENCY);
		
		assertThat(GOODS.equals(offer.getGoods()));
		assertThat(DESCRIPTION.equals(offer.getDescription()));
		assertThat(PRICE == offer.getPrice());
		assertThat(CURRENCY.equals(offer.getCurrency()));
	}
	
	@Test
	public void updateOffer() {
		when(offerRepository.findOne(ID)).thenReturn(OFFER);
		when(offerRepository.save(OFFER)).thenReturn(OFFER);

		Offer offer = offerManager.update(ID, GOODS_UPDATED, DESCRIPTION_UPDATED, PRICE_UPDATED, CURRENCY_UPDATED);
		
		assertThat(ID == offer.getId());
		assertThat(GOODS_UPDATED.equals(offer.getGoods()));
		assertThat(DESCRIPTION_UPDATED.equals(offer.getDescription()));
		assertThat(PRICE_UPDATED == offer.getPrice());
		assertThat(CURRENCY_UPDATED.equals(offer.getCurrency()));
	}
	
	@Test
	public void nonExistingOfferCannotBeUpdated() {
		when(offerRepository.findOne(ID)).thenReturn(null);

		Offer offer = offerManager.update(ID, GOODS_UPDATED, DESCRIPTION_UPDATED, PRICE_UPDATED, CURRENCY_UPDATED);
		
		assertThat(offer == null);
	}
}
