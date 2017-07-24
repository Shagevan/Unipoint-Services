package com.unipoint.merchant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unipoint.merchant.dataaccess.OfferClaimDao;
import com.unipoint.merchant.dataaccess.OfferDao;
import com.unipoint.merchant.model.MerchantUser;
import com.unipoint.merchant.model.Offer;
import com.unipoint.merchant.model.OfferClaim;
import com.unipoint.merchant.model.UnipointCustomerProfile;
import com.unipoint.merchant.response.OfferClaimHistory;
import com.unipoint.merchant.response.OfferClaimHistoryResponse;
import com.unipoint.merchant.service.OffersService;

@Service
public class OffersServiceImpl implements OffersService {
	
	@Autowired
	private OfferClaimDao offerClaimRepository;
	
	@Autowired
	private OfferDao offerRepository;

	@Transactional
	public OfferClaimHistoryResponse getOfferClaimingHistory(String merchantUserRefId) {
		
		OfferClaimHistoryResponse response = new OfferClaimHistoryResponse();
		List<OfferClaimHistory> offerClaimHistories = new ArrayList<>();
		List<OfferClaim> offerClaims = offerClaimRepository.getOfferClaim(new MerchantUser(Long.valueOf(merchantUserRefId)));
		if(offerClaims != null){
			for (OfferClaim offerClaim : offerClaims) {
				OfferClaimHistory obj = new OfferClaimHistory();
				Offer offer = offerRepository.getOfferByOfferRefId(offerClaim.getOffer().getOfferid());
				if(offer != null){
					obj.setOfferName(offer.getOfferHeading());
					obj.setOfferCode(offer.getOfferRedemtionCode());
					obj.setClaimedDate(offerClaim.getDateTimeClaimed());
					offerClaimHistories.add(obj);
				}
			}
			response.setError(null);
			response.setMessage("Successfull");
			response.setOfferClaimHistory(offerClaimHistories);
		}
		else{
			response.setError("No offers");
		}
		
		return response;
	}

	@Transactional
	public OfferClaimHistoryResponse releaseOffer(String offerRefId, String merchantUserRefId, String unipointCustomerRefId, String pointsAdded) {
		
		OfferClaim offerClaim = new OfferClaim();
		offerClaim.setUnipointCustomerProfile(new UnipointCustomerProfile(Long.valueOf(unipointCustomerRefId)));
		offerClaim.setMerchantUserByAddedByRef(new MerchantUser(Long.valueOf(merchantUserRefId)));
		offerClaim.setMerchantUserByLastModifiedByRef(new MerchantUser(Long.valueOf(merchantUserRefId)));
		offerClaim.setMerchantPointsAdded(Float.valueOf(pointsAdded));
		offerClaim.setOffer(new Offer(Long.valueOf(offerRefId)));
		
		offerClaimRepository.addOfferClaim(offerClaim);
		return getOfferClaimingHistory(merchantUserRefId);
	}

}
