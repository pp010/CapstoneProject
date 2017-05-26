package com.bms.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.service.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	@Autowired
	StockService stockService;

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public JSONObject getList() {
		return stockService.getList();
	}
	
	@RequestMapping(value = "/insertList", method = RequestMethod.POST)
	public JSONObject insertList(@RequestBody String input) {
		return stockService.insertList(input);
	}
	
	@RequestMapping(value = "/updateList/{id}", method = RequestMethod.PUT)
	public JSONObject updateList(@RequestBody String input) {
		return stockService.insertList(input);
	}
	
}
