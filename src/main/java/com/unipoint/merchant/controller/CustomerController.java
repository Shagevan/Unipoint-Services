package com.unipoint.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unipoint.merchant.model.MerchantCustomer;
import com.unipoint.merchant.service.MerchantCustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	MerchantCustomerService merchantCustomerService;
	
	@RequestMapping(value = "/find", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	MerchantCustomer findCustomer(@RequestBody MerchantCustomer customer) {
		try {
			MerchantCustomer merchantSynced = merchantCustomerService.searchCustomer(customer.getCustomerFirstName(),customer.getCustomerLastName(),customer.getPostalAddress(),customer.getMobilePhoneNumber());
			return merchantSynced;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	MerchantCustomer getCustomer(@PathVariable("id") int accountNo) {
		MerchantCustomer merchantSynced = null;
		try {
		
			merchantSynced = merchantCustomerService.getCustomer(accountNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchantSynced;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<MerchantCustomer> getAllCustomers() {

		List<MerchantCustomer> merchantList = null;
		try {
			merchantList = merchantCustomerService.getAllCustomers();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return merchantList;
	}
}
