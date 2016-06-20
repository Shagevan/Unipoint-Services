package com.unipoint.merchant.service;

import java.util.List;

import com.unipoint.merchant.model.MerchantCustomer;

public interface MerchantCustomerService {
	public MerchantCustomer searchCustomer(String firstName,String lastName,String address,int mobileNo);
	public List<MerchantCustomer> getAllCustomers();
	public MerchantCustomer getCustomer(int accountNo);
}
