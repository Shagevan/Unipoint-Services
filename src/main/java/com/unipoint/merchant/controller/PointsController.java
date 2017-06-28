package com.unipoint.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.unipoint.merchant.response.TransctionHistoryResponse;
import com.unipoint.merchant.service.PointsService;

@Controller
@RequestMapping("/points")
public class PointsController {
	
	@Autowired
	private PointsService pointsService;

	@RequestMapping(value = "/addFromInvoice", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	TransctionHistoryResponse addPointsFromInvoice(@RequestParam String customerMobileNumber, @RequestParam int invoiceNumber, 
			@RequestParam int merchantUserRefId, @RequestParam int outletRefId) {
		return pointsService.addPointsFromInvoice(customerMobileNumber,invoiceNumber,merchantUserRefId, outletRefId);
	}
	
	@RequestMapping(value = "/addFromAmount", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	TransctionHistoryResponse addPointsFromAmount(@RequestParam String customerMobileNumber, @RequestParam int billAmount,
			@RequestParam int merchantUserRefId, @RequestParam int outletRefId) {
		return pointsService.addPointsFromAmount(customerMobileNumber,billAmount,merchantUserRefId,outletRefId);
	}
	
	@RequestMapping(value = "/getTransactionHistory", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	TransctionHistoryResponse getTransactionHistory(@RequestParam int merchantUserRefId, @RequestParam int outletRefId) {
		return pointsService.getTransactionHistory(merchantUserRefId,outletRefId);
	}
	
	@RequestMapping(value = "/redeem", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	TransctionHistoryResponse redeemPoints(@RequestParam String customerMobileNumber, @RequestParam double billValue,
			@RequestParam double points, @RequestParam int merchantUserRefId, @RequestParam int outletRefId) {
		return pointsService.redeemPoints(customerMobileNumber,billValue, points, merchantUserRefId, outletRefId);
	}
	
}
