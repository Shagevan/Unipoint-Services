package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.PointRewards;

public interface PointRewardsDao {
	public void addPointRewards(PointRewards pointRewards);
	public List<PointRewards> getAllPointRewards();
	public void deletePointRewards(int customerRefId);
	public PointRewards getPointRewards(int customerRefId);
	public void updatePointRewards(int customerRefId, PointRewards pointRewards);
}
