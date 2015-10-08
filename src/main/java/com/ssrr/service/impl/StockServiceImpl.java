package com.ssrr.service.impl;

import org.springframework.stereotype.Service;

import com.ssrr.domain.Stock;
import com.ssrr.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Override
	public Stock findStockByTicker(String ticker) {
		// TODO Auto-generated method stub
		return new Stock(ticker, "Enagas");
	}


}
