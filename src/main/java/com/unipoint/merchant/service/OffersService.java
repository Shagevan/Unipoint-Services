package com.unipoint.merchant.service;

import com.unipoint.merchant.response.OfferClaimHistoryResponse;

public interface OffersService {
	public OfferClaimHistoryResponse getOfferClaimingHistory(String merchantUserRefId);
	public OfferClaimHistoryResponse releaseOffer(String offerRefId, String merchantUserRefId, String unipointCustomerRefId, String pointsAdded);
}
