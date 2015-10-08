package com.ssrr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssrr.domain.Quote;
import com.ssrr.service.DummyService;

@RestController
public class DummyController {

	@Autowired
	private DummyService dummyService;
	
	@RequestMapping("/dummy")
	public Quote requestApiRandom() {
		return dummyService.requestApiRandom();
	}
}
