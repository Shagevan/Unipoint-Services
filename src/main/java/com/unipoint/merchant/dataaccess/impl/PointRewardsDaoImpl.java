package com.unipoint.merchant.dataaccess.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.unipoint.merchant.dataaccess.PointRewardsDao;
import com.unipoint.merchant.model.PointRewards;
import com.unipoint.merchant.model.UnipointCustomerProfile;

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

	public void deletePointRewards(UnipointCustomerProfile unipointCustomer) {
		session.getCurrentSession().delete(getPointRewards(unipointCustomer));
	}

	public PointRewards getPointRewards(UnipointCustomerProfile unipointCustomer) {
		return (PointRewards) session.getCurrentSession().get(PointRewards.class,
				unipointCustomer.getUnipointcustomerid());
	}
	
	public void updatePointRewards(UnipointCustomerProfile unipointCustomer, PointRewards pointRewards) {
		PointRewards obj = getPointRewards(unipointCustomer);
		if(obj == null){
			addPointRewards(pointRewards);
		}
		else{
			session.getCurrentSession().update(pointRewards);
		}
	}
}
