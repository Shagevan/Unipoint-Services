package com.unipoint.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unipoint.merchant.response.OfferClaimHistoryResponse;
import com.unipoint.merchant.service.OffersService;

@Controller
@RequestMapping("/offers")
public class OffersController {
	
	@Autowired
	private OffersService offersService;
	
	@RequestMapping(value = "/getOfferClaimingHistory", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	OfferClaimHistoryResponse getOfferClaimingHistory(@RequestParam String merchantUserRefId) {
		return offersService.getOfferClaimingHistory(merchantUserRefId);
	}
	
	@RequestMapping(value = "/releaseOffer", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	OfferClaimHistoryResponse releaseOffer(@RequestParam String offerRefId, @RequestParam String merchantUserRefId, 
			@RequestParam String unipointCustomerRefId, @RequestParam String pointsAdded) {
		return offersService.releaseOffer(offerRefId, merchantUserRefId, unipointCustomerRefId, pointsAdded);
	}

}
