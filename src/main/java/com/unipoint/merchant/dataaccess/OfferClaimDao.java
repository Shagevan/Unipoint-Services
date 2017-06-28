package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.MerchantUser;
import com.unipoint.merchant.model.OfferClaim;

public interface OfferClaimDao {
	public void addOfferClaim(OfferClaim offerClaim);
	public List<OfferClaim> getOfferClaim(MerchantUser merchantUser);
}
