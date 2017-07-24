package com.unipoint.merchant.service;

import com.unipoint.merchant.response.TransctionHistoryResponse;

public interface PointsService {
	public TransctionHistoryResponse addPointsFromInvoice(String customerMobileNumber,String invoiceNumber, String merchantUserRefId);
	public TransctionHistoryResponse addPointsFromAmount(String customerMobileNumber,String billAmount, String merchantUserRefId, String transactionType);
	public TransctionHistoryResponse redeemPoints(String customerMobileNumber,String billValue,String points, String merchantUserRefId, String transactionType);
	public TransctionHistoryResponse getTransactionHistory(String merchantUserRefId);
}
