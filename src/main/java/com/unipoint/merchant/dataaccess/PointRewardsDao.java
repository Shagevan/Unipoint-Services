package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.PointRewards;
import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface PointRewardsDao {
	public void addPointRewards(PointRewards pointRewards);
	public List<PointRewards> getAllPointRewards();
	public PointRewards getPointRewards(UnipointCustomerProfile unipointCustomer);
	public void updatePointRewards(UnipointCustomerProfile unipointCustomer, PointRewards pointRewards);
}
