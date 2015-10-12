package com.ssrr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.ssrr.domain.Quote;
import com.ssrr.service.DummyService;

@Service
public class DummyServiceImpl implements DummyService {

	private RestOperations restTemplate = new RestTemplate();

	@Override
	public Quote requestApiRandom() {
		Quote quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

		return quote;
	}


}
