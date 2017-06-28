package com.unipoint.merchant.service;

import com.unipoint.merchant.response.GetCustomerDetailResponse;
import com.unipoint.merchant.response.MerchantUserLoginResponse;

public interface MerchantUserService {
	public MerchantUserLoginResponse login(String username, String password);
	public GetCustomerDetailResponse getCustomerDetails(String cardNumber);
}
