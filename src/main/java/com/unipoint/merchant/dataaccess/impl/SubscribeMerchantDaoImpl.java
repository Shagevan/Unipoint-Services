package com.unipoint.merchant.dataaccess.impl;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.SubscribeMerchantDao;
import com.unipoint.merchant.model.SubscribeMerchant;
import com.unipoint.merchant.model.UnipointCustomerProfile;

@Repository
public class SubscribeMerchantDaoImpl implements SubscribeMerchantDao{
	
	@Autowired
	private SessionFactory session;

	@Override
	public SubscribeMerchant getSubscribeMerchant(int customerRefId) {
		return (SubscribeMerchant) session.getCurrentSession().get(SubscribeMerchant.class,
				customerRefId);
	}
	
	@Override
	public void updatePoints(String code, UnipointCustomerProfile unipointCustomerProfile, double points){
		
		Query first_query = session.getCurrentSession().createQuery("from SubscribeMerchant where unipointCustomerProfile = :unipointCustomerProfile");
		first_query.setParameter("unipointCustomerProfile", unipointCustomerProfile);
		SubscribeMerchant merchant = (SubscribeMerchant) first_query.uniqueResult();
		BigDecimal updatedPoints;
		if(code.equals("Add")){
			updatedPoints = merchant.getTotalpoints().add(BigDecimal.valueOf(points));
		}
		else{
			updatedPoints = merchant.getTotalpoints().subtract(BigDecimal.valueOf(points));
		}
		
		Query second_query = session.getCurrentSession().createQuery("update SubscribeMerchant set totalpoints = :totalpoints" +
				" where unipointCustomerProfile = :unipointCustomerProfile");
		second_query.setParameter("totalpoints", updatedPoints);
		second_query.setParameter("unipointCustomerProfile", unipointCustomerProfile);
		second_query.executeUpdate();
	}

	@Override
	public SubscribeMerchant getSubscribeMerchantByCardNumber(String cardNumber) {
		Query query = session.getCurrentSession().createQuery("from SubscribeMerchant where cardnumber = :cardnumber");
		query.setParameter("cardnumber", cardNumber);
		SubscribeMerchant merchant = (SubscribeMerchant) query.uniqueResult();
		return merchant;
	}

}
