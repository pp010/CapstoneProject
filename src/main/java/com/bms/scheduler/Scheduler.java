package com.bms.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bms.bidPriceComparator.BidPriceComparator;
import com.bms.domain.BidList;
import com.bms.domain.CreateBidList;
import com.bms.repostiries.JpaBidList;
import com.bms.repostiries.JpaCreateBidList;

@Component
public class Scheduler {

	@Autowired
	JpaBidList jpaBidList;

	@Autowired
	JpaCreateBidList jpaCreateBidList;

	@Scheduled(fixedDelayString = "${db_check}")
	public void scheduler() throws ParseException {

		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		Date date = new Date();
		System.out.println("#####" + date + "#####");

		List<CreateBidList> createdBidList = jpaCreateBidList.findAll();
		List<BidList> bidLists = jpaBidList.findAll();

		for (CreateBidList createBidList : createdBidList) {
			if (date.after(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(createBidList.getEndDate()))) {
				List<BidList> successBids = new ArrayList<>();
				for (BidList bidList : bidLists) {
					if (bidList.getBidId().equalsIgnoreCase(createBidList.getId())) {
						successBids.add(bidList);
						jpaBidList.delete(bidList.getId());
					}
				}
				Collections.sort(successBids, new BidPriceComparator());
				for (BidList bl : successBids) {
					System.out.println("*****" + bl + "*****");
				}
				jpaCreateBidList.delete(createBidList.getId());
			}
		}

	}

}
