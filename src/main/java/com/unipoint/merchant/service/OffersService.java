package com.unipoint.merchant.service;

import com.unipoint.merchant.response.OfferClaimHistoryResponse;

public interface OffersService {
	public OfferClaimHistoryResponse getOfferClaimingHistory(int merchantUserRefId);
	public OfferClaimHistoryResponse releaseOffer(int offerRefId, int merchantUserRefId, int unipointCustomerRefId, int pointsAdded);
}
