package com.ssrr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssrr.domain.Stock;
import com.ssrr.service.StockService;

@RestController
public class StockRestController {

	@Autowired
	private StockService stockService;

	@RequestMapping("/ticker/{ticker}")
	public Stock findStockByTicker(@PathVariable String ticker) {
		return stockService.findStockByTicker(ticker);
	}

	@RequestMapping("/market/{market}/ticker/{ticker}")
	public Stock findStockByTickerAndMarket(String market, String ticker) {
		return stockService.findStockByTickerAndMarket(market, ticker);
	}

}
