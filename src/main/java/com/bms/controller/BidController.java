package com.bms.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.domain.BidList;
import com.bms.domain.CreateBidList;
import com.bms.service.BidService;

@CrossOrigin
@RestController
@RequestMapping(value = "/bid")
public class BidController {

	@Autowired
	BidService bidService;

	@RequestMapping(value = "/bidList", method = RequestMethod.GET)
	public List<CreateBidList> getList() throws ParseException, java.text.ParseException {
		return bidService.getList();

	}

	@RequestMapping(value = "/bidItem", method = RequestMethod.POST)
	public JSONObject getList(@RequestBody String input) throws ParseException, java.text.ParseException {
		return bidService.bidItem(input);
	}

	@RequestMapping(value = "/allBids", method = RequestMethod.GET)
	public List<BidList> allBids() {
		return bidService.allBids();
	}
}
