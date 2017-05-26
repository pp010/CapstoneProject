package com.bms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.domain.BidList;
import com.bms.repostiries.JpaBidList;

public class BidService {

	@Autowired
	JpaBidList jpaBidList;
	
	private String start = "${bid.start.date}";
	private String end = "${bid.end.date}";

	public List<BidList> bidItem(String input, String productId) throws ParseException, java.text.ParseException {
		Object obj = new JSONParser().parse(input);
		JSONObject json = (JSONObject) obj;
		Date date = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss").parse((String) json.get("date"));
		Date startDate = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss").parse(start);
		Date endDate = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss").parse(end);
		
		if(date.before(endDate) && date.after(startDate)){
			jpaBidList.insert(new BidList((String) json.get("biddingPrice"), (String) json.get("emailId"),
					(String) json.get("productName"), productId));
		}  else {
			//"Bidding closed";
		}

		
		return jpaBidList.findAll();

	}


}
