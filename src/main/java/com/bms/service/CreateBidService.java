package com.bms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.domain.CreateBidList;
import com.bms.repostiries.JpaCreateBidList;

@Service
public class CreateBidService {

	@Autowired
	private JpaCreateBidList jpaCreateBidList;

	@SuppressWarnings("unchecked")
	public JSONObject openBid(String input, Date date) throws ParseException, java.text.ParseException {

		Object obj = new JSONParser().parse(input);
		JSONObject json = (JSONObject) obj;

		Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) json.get("startDate"));
		Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) json.get("endDate"));

		JSONObject status = new JSONObject();
		
		if (endDate.after(startDate) && date.before(endDate)) {
			jpaCreateBidList.insert(new CreateBidList((String) json.get("startDate"), (String) json.get("endDate"),
					(String) json.get("productName"), (String) json.get("productId"),
					(String) json.get("bidBasePrice")));

			status.put("status", "success");
		} else {
			status.put("status", "Bid creation failed");
			status.put("issue", "Please check start and end date");
		}

		return status;
	}

	public List<CreateBidList> getList() {
		return jpaCreateBidList.findAll();
	}

}
