package com.unipoint.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unipoint.merchant.response.GetCustomerDetailResponse;
import com.unipoint.merchant.response.MerchantUserLoginResponse;
import com.unipoint.merchant.service.MerchantUserService;

@Controller
@RequestMapping("/merchantUser")
public class MerchantUserController {
	
	@Autowired
	private MerchantUserService merchantUserService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	MerchantUserLoginResponse addPointsFromInvoice(@RequestParam String userName, @RequestParam String password) {
		return merchantUserService.login(userName,password);
	}
	
	@RequestMapping(value = "/getCustomerDetails", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	GetCustomerDetailResponse getCustomerDetails(@RequestParam String cardNumber) {
		return merchantUserService.getCustomerDetails(cardNumber);
	}

}
