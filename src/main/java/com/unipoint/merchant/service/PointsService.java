package com.unipoint.merchant.service;

import com.unipoint.merchant.response.TransctionHistoryResponse;

public interface PointsService {
	public TransctionHistoryResponse addPointsFromInvoice(String customerMobileNumber,int invoiceNumber,
			int merchantUserRefId, int outletRefId);
	public TransctionHistoryResponse addPointsFromAmount(String customerMobileNumber,int billAmount,
			int merchantUserRefId, int outletRefId);
	public TransctionHistoryResponse getTransactionHistory(int merchantUserRefId, int outletRefId);
	public TransctionHistoryResponse redeemPoints(String customerMobileNumber,double billValue,double points,
			int merchantUserRefId, int outletRefId);
}
