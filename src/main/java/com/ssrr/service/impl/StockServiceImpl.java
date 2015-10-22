package com.ssrr.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssrr.domain.Stock;
import com.ssrr.domain.YahooResource;
import com.ssrr.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	private static final String NYSE = "NYSE";

	private static final String URL_MARKIT_ON_DEMAND = "http://dev.markitondemand.com/Api/v2/Quote/json";
	private static final String URL_YAHOO_WEB_SERVICE = "http://finance.yahoo.com/webservice/v1/symbols/{symbol}/quote";

	private RestOperations restTemplate = new RestTemplate();

	@Override
	public Stock findStockByTicker(String ticker) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_MARKIT_ON_DEMAND).queryParam("symbol",
				ticker);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Stock> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity,
				Stock.class);

		return response.getBody();
	}

	@Override
	public YahooResource findStockByTickerAndMarket(String market, String ticker) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_YAHOO_WEB_SERVICE).queryParam("format",
				"json");
		builder.queryParam("view", "detail");
		UriComponents uriComponents = null;
		if (market.equals(NYSE)) {
			uriComponents = builder.buildAndExpand(ticker);
		} else {
			uriComponents = builder.buildAndExpand(ticker + "." + market);
		}

		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		HttpEntity<YahooResource> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity,
				YahooResource.class);

		return response.getBody();
	}


}
