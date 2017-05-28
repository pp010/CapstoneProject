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
		JSONObject json = new JSONObject();
		json.put("date", "28/05/2017 20:00:00");
		CreateBidList createBidList = new CreateBidList("28/05/2017 18:00:00", "28/05/2017 21:00:00", "", "", "50000");

		Date startDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(createBidList.getStartDate());
		Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(createBidList.getEndDate());

		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse((String) json.get("date"));

		if (date.before(endDate) && date.after(startDate)) {
			System.out.println(date);
			System.out.println(startDate);
			System.out.println(endDate);
		} else {
			// "Bidding closed";
		}
		
		/*CreateBidList createBidList = new CreateBidList("27/05/2017 00:00:00", "28/05/2017 00:00:00", "", "", "50000");
		JSONObject json = new JSONObject();
		json.put("biddingPrice", "55000");
		if (Integer.valueOf(createBidList.getbidBasePrice()) < Integer.valueOf((String) json.get("biddingPrice"))) {
			System.out.println("");
		}*/
	}

}
