package com.ssrr.service;

import com.ssrr.domain.Stock;

public interface StockService {

	Stock findStockByTicker(String ticker);

	Stock findStockByTickerAndMarket(String market, String ticker);

}
