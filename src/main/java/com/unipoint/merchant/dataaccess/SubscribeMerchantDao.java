package com.unipoint.merchant.dataaccess;

import com.unipoint.merchant.model.SubscribeMerchant;
import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface SubscribeMerchantDao {
	public SubscribeMerchant getSubscribeMerchant(int customerRefId);
	public SubscribeMerchant getSubscribeMerchantByCardNumber(String cardNumber);
	public void updatePoints(String code, UnipointCustomerProfile unipointCustomerProfile,double points);
}
