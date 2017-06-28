package com.unipoint.merchant.response;

import java.util.List;

public class TransctionHistoryResponse {
	
	private List<TransactionHistory> transactionHistory;
	private String error;
	private String message;
	
	public List<TransactionHistory> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
