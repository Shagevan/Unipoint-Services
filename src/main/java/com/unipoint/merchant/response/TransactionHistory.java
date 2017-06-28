package com.unipoint.merchant.response;

public class TransactionHistory {
	
	private String phoneNumber;
	private String pointsAwarded;
	private String billValue;
	private String invoiceNumber;
	private String TransactionDateTime;
	private String loyalityLevel;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPointsAwarded() {
		return pointsAwarded;
	}
	public void setPointsAwarded(String pointsAwarded) {
		this.pointsAwarded = pointsAwarded;
	}
	public String getBillValue() {
		return billValue;
	}
	public void setBillValue(String billValue) {
		this.billValue = billValue;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getTransactionDateTime() {
		return TransactionDateTime;
	}
	public void setTransactionDateTime(String transactionDateTime) {
		TransactionDateTime = transactionDateTime;
	}
	public String getLoyalityLevel() {
		return loyalityLevel;
	}
	public void setLoyalityLevel(String loyalityLevel) {
		this.loyalityLevel = loyalityLevel;
	}

}
