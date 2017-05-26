package com.bms.controller;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.domain.BidList;
import com.bms.service.BidService;

@CrossOrigin
@RestController
@RequestMapping(value = "/bid")
public class BidController {

	@Autowired
	BidService bidService;

	@RequestMapping(value = "/bidItem/{id}", method = RequestMethod.POST)
	public List<BidList> getList(@RequestBody String input, @RequestParam String productId) throws ParseException, java.text.ParseException {
		return bidService.bidItem(input, productId);

	}
}
