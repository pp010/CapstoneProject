package com.bms.domain;

import org.springframework.data.annotation.Id;

public class BidList {
	
	@Id
	private String id;
	private String biddingPrice;
	private String emailId;
	private String productName;
	private String productId;
	private String bidId;

	public BidList() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBiddingPrice() {
		return biddingPrice;
	}

	public void setBiddingPrice(String biddingPrice) {
		this.biddingPrice = biddingPrice;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}


	public BidList(String biddingPrice, String emailId, String productName, String productId, String bidId) {
		super();
		this.biddingPrice = biddingPrice;
		this.emailId = emailId;
		this.productName = productName;
		this.productId = productId;
		this.bidId = bidId;
	}

	@Override
	public String toString() {
		return "BidList [id=" + id + ", biddingPrice=" + biddingPrice + ", emailId=" + emailId + ", productName="
				+ productName + ", productId=" + productId + ", bidId=" + bidId + "]";
	}
	
	
	
}
