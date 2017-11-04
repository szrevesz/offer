package com.srevesz.offer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.srevesz.offer.model.Offer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OfferRepositoryTest {
	private static final String GOODS = "Coffee Machine";
	private static final String DESCRIPTION = "Best offer ever, buy me now";
	private static final Double PRICE = 99.99;
	private static final String CURRENCY = "GBP";

	private static final String GOODS_UPDATED = "Coffee Machine 2.0";
	private static final String DESCRIPTION_UPDATED = "Best offer ever, buy me now!!!";
	private static final Double PRICE_UPDATED = 89.99;
	private static final String CURRENCY_UPDATED = "EUR";
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
	public void savingAndFind() {
		Offer offer = new Offer(GOODS, DESCRIPTION, PRICE, CURRENCY);
		offer = offerRepository.save(offer);
		
		Offer foundOffer = offerRepository.findOne(offer.getId());
		
		assertThat(offer.getId() == foundOffer.getId());
		assertThat(offer.getGoods().equals(foundOffer.getGoods()));
		assertThat(offer.getDescription().equals(foundOffer.getDescription()));
		assertThat(offer.getPrice() == foundOffer.getPrice());
		assertThat(offer.getCurrency().equals(foundOffer.getCurrency()));
	}
	
	@Test
	public void savingUpdatingAndFind() {
		//creating
		Offer offer = new Offer(GOODS, DESCRIPTION, PRICE, CURRENCY);
		offer = offerRepository.save(offer);
		
		//updating
		offer.setGoods(GOODS_UPDATED);
		offer.setDescription(DESCRIPTION_UPDATED);
		offer.setPrice(PRICE_UPDATED);
		offer.setCurrency(CURRENCY_UPDATED);
		
		//updating in the database
		offer = offerRepository.save(offer);
		
		//finding by ID
		Offer foundOffer = offerRepository.findOne(offer.getId());
		
		//should be de changed values
		assertThat(offer.getId() == foundOffer.getId());
		assertThat(GOODS_UPDATED.equals(foundOffer.getGoods()));
		assertThat(DESCRIPTION_UPDATED.equals(foundOffer.getDescription()));
		assertThat(PRICE_UPDATED == foundOffer.getPrice());
		assertThat(CURRENCY_UPDATED.equals(foundOffer.getCurrency()));
	}
	
}
