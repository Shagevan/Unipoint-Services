package com.unipoint.merchant.response;

public class OfferClaimHistory {

	private String offerName;
	private String offerCode;
	private String claimedDate;
	private String loyalityLevel;
	
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public String getClaimedDate() {
		return claimedDate;
	}
	public void setClaimedDate(String claimedDate) {
		this.claimedDate = claimedDate;
	}
	public String getLoyalityLevel() {
		return loyalityLevel;
	}
	public void setLoyalityLevel(String loyalityLevel) {
		this.loyalityLevel = loyalityLevel;
	}
	
}
