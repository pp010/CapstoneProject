package com.bms.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.service.StockService;

/**
 * Controller class to handle request for inventory
 * 
 * @author 540010
 *
 */
@CrossOrigin
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
	public JSONObject updateList(@RequestBody String input, @PathVariable (value = "id") String id) {
		return stockService.updateList(id,input);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public JSONObject deleteList(@PathVariable (value = "id") String id) {
		return stockService.deleteList(id);
	}
}
