package com.bms.bidPriceComparator;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.bms.domain.BidList;

@Component
public class BidPriceComparator implements Comparator<BidList> {

	@Override
	public int compare(BidList bid1, BidList bid2) {

		int bidPriceOfBid1 = Integer.valueOf(bid1.getBiddingPrice());
		int bidPriceOfBid2 = Integer.valueOf(bid2.getBiddingPrice());

		if (bidPriceOfBid1 == bidPriceOfBid2)
			return 0;
		else if (bidPriceOfBid1 == bidPriceOfBid2)
			return 1;
		else
			return -1;
	}

}
