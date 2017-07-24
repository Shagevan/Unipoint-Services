package com.unipoint.merchant.dataaccess;

import com.unipoint.merchant.model.MerchantUser;

public interface MerchantUserDao {
	public MerchantUser validateLogin(String userName, String password);
	public MerchantUser getMerchantUserById(long merchantUserRefId);
}
