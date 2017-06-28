package com.unipoint.merchant.dataaccess.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.PointConversionDao;
import com.unipoint.merchant.dataaccess.PointRewardsDao;
import com.unipoint.merchant.model.MerchantCustomer;
import com.unipoint.merchant.model.PointRewards;

@Repository
public class PointRewardsDaoImpl implements PointRewardsDao {

	@Autowired
	private SessionFactory session;
	
	public void addPointRewards(PointRewards pointRewards) {
		session.getCurrentSession().save(pointRewards);
	}
	
	@SuppressWarnings("unchecked")
	public List<PointRewards> getAllPointRewards() {
		return session.getCurrentSession().createQuery("from point_rewards").list();
	}

	public void deletePointRewards(int customerRefId) {
		session.getCurrentSession().delete(getPointRewards(customerRefId));
	}

	public PointRewards getPointRewards(int customerRefId) {
		return (PointRewards) session.getCurrentSession().get(PointRewards.class,
				customerRefId);
	}
	
	public void updatePointRewards(int customerRefId, PointRewards pointRewards) {
		PointRewards obj = getPointRewards(customerRefId);
		if(obj == null){
			addPointRewards(pointRewards);
		}
		else{
			session.getCurrentSession().update(pointRewards);
		}
	}
}
