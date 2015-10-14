package com.ssrr.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssrr.domain.Stock;
import com.ssrr.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	private RestOperations restTemplate = new RestTemplate();

	@Override
	public Stock findStockByTicker(String ticker) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		String url = "http://dev.markitondemand.com/Api/v2/Quote/json";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("symbol", ticker);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Stock> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity,
				Stock.class);

//		http://dev.markitondemand.com/Api/v2/Quote/json?symbol=AAPL
		System.out.println(response);
		System.out.println(response.getBody());
		// return response.getBody();
		return response.getBody();
	}

	@Override
	public Stock findStockByTickerAndMarket(String market, String ticker) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		// http://finance.yahoo.com/webservice/v1/symbols/ENG.MC/quote?format=json&view=detail
		String url = "http://finance.yahoo.com/webservice/v1/symbols/{symbol}/quote";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("format", "json");
		builder.queryParam("view", "detail");
		builder.buildAndExpand("ENG.MC");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		HttpEntity<Stock> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity,
				Stock.class);

		HttpEntity<String> response2 = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity,
				String.class);
		System.out.println(response2.getBody());
		System.out.println(response);
		System.out.println(response.getBody());
		return response.getBody();
	}


}
