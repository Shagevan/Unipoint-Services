package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface UniPointCustomerProfileDao {
	public void addUniPointCustomerProfile(UnipointCustomerProfile uniPointCustomer);
	public List<UnipointCustomerProfile> getAllUniPointCustomerProfile();
	public void deleteUniPointCustomerProfile(int uniPointCustomerId);
	public UnipointCustomerProfile getUniPointCustomerProfile(int uniPointCustomerId);
	public UnipointCustomerProfile getUniPointCustomerByMobile(String mobileNumber);
}
