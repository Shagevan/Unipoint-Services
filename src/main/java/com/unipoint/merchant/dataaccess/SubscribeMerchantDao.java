package com.unipoint.merchant.dataaccess;

import com.unipoint.merchant.model.Merchant;
import com.unipoint.merchant.model.SubscribeMerchant;
import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface SubscribeMerchantDao {
	public SubscribeMerchant getSubscribeMerchant(UnipointCustomerProfile unipointCustomerProfile, Merchant merchant);
	public SubscribeMerchant getSubscribeMerchantByCardNumber(String cardNumber);
	public void updatePoints(String code, UnipointCustomerProfile unipointCustomerProfile, Merchant merchant, double points);
}
