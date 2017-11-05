package com.srevesz.offer.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.srevesz.offer.model.Offer;
import com.srevesz.offer.service.OfferManager;

@RunWith(SpringRunner.class)
@WebMvcTest(OfferController.class)
public class OfferControllerTest {
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
	private static final Offer OFFER_UPDATE = new Offer(GOODS_UPDATED, DESCRIPTION_UPDATED, PRICE_UPDATED, CURRENCY_UPDATED);;
	
	@Autowired
	private OfferController offerController;
	
	@MockBean
	private OfferManager offerManager;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void createOffer() throws Exception {
		when(offerManager.save(GOODS, DESCRIPTION, PRICE, CURRENCY)).thenReturn(OFFER);
		
		//Action
		ResultActions result = mvc.perform(post("/api/offer")
				.param("goods", GOODS)
				.param("description", DESCRIPTION)
				.param("price", PRICE.toString())
				.param("currency", CURRENCY));
		
		//Checking the response
		result.andExpect(status().isOk())
				.andExpect(jsonPath("goods").value(GOODS))
				.andExpect(jsonPath("description").value(DESCRIPTION))
				.andExpect(jsonPath("price").value(PRICE))
				.andExpect(jsonPath("currency").value(CURRENCY));
	}
	
	@Test
	public void updateOffer() throws Exception {
		when(offerManager.update(ID, GOODS_UPDATED, DESCRIPTION_UPDATED, PRICE_UPDATED, CURRENCY_UPDATED)).thenReturn(OFFER_UPDATE);
		
		//Action
		ResultActions result = mvc.perform(put("/api/offer")
				.param("id", ID.toString())
				.param("goods", GOODS_UPDATED)
				.param("description", DESCRIPTION_UPDATED)
				.param("price", PRICE_UPDATED.toString())
				.param("currency", CURRENCY_UPDATED));
		
		//Checking the response
		result.andExpect(status().isOk())
				.andExpect(jsonPath("goods").value(GOODS_UPDATED))
				.andExpect(jsonPath("description").value(DESCRIPTION_UPDATED))
				.andExpect(jsonPath("price").value(PRICE_UPDATED))
				.andExpect(jsonPath("currency").value(CURRENCY_UPDATED));
	}
	
	@Test
	public void deleteOffer() throws Exception {
		//Action
		ResultActions result = mvc.perform(delete("/api/offer/{id}", ID));
		
		//Checking the response
		result.andExpect(status().isOk());
	}
	
	@Test
	public void getOneOffer() throws Exception {
		//Action
		ResultActions result = mvc.perform(get("/api/offer/{id}", ID));
		
		//Checking the response
		result.andExpect(status().isOk());
	}
	
	@Test
	public void getAllOffer() throws Exception {
		//Action
		ResultActions result = mvc.perform(get("/api/offers"));
		
		//Checking the response
		result.andExpect(status().isOk());
	}
}
