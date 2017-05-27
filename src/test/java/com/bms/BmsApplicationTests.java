package com.bms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bms.domain.BidList;
import com.bms.domain.CreateBidList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BmsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
		/*JSONObject json = new JSONObject();
		json.put("id", "592990ba1bd93d000daf47d6");
		json.put("startDate", "27/05/2017 00:00:00");
		json.put("endDate", "28/05/2017 24:00:00");
		json.put("productName", "Moto g");
		json.put("productId", "1004");
		json.put("bidBasePrice", "50000");

		Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) json.get("startDate"));
		Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) json.get("endDate"));

		Date date = new Date();

		if (date.before(endDate) && date.after(startDate)) {
			System.out.println(date + " " + startDate + " " + endDate);
		} else {
			// "Bidding closed";
		}*/
		
		CreateBidList createBidList = new CreateBidList("27/05/2017 00:00:00", "28/05/2017 00:00:00", "", "", "50000");
		JSONObject json = new JSONObject();
		json.put("biddingPrice", "55000");
		if (Integer.valueOf(createBidList.getbidBasePrice()) < Integer.valueOf((String) json.get("biddingPrice"))) {
			System.out.println("");
		}
	}

}
