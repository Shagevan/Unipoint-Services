package com.unipoint.merchant.dataaccess;

import com.unipoint.merchant.model.Offer;

public interface OfferDao {
	
	public Offer getOfferByOfferRefId(long offerRefId);

}
