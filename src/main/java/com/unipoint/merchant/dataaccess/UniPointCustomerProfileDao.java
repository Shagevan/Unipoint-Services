package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface UniPointCustomerProfileDao {
	public void addUniPointCustomerProfile(UnipointCustomerProfile uniPointCustomer);
	public List<UnipointCustomerProfile> getAllUniPointCustomerProfile();
	public void deleteUniPointCustomerProfile(long uniPointCustomerId);
	public UnipointCustomerProfile getUniPointCustomerProfile(long uniPointCustomerId);
	public UnipointCustomerProfile getUniPointCustomerByMobile(String mobileNumber);
}
