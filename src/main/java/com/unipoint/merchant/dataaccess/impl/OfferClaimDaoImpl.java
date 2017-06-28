package com.unipoint.merchant.dataaccess.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.OfferClaimDao;
import com.unipoint.merchant.model.MerchantUser;
import com.unipoint.merchant.model.Offer;
import com.unipoint.merchant.model.OfferClaim;

@Repository
public class OfferClaimDaoImpl implements OfferClaimDao{
	
	@Autowired
	private SessionFactory session;
	
	public void addOfferClaim(OfferClaim offerClaim){
		session.getCurrentSession().save(offerClaim);
	}
	
	@SuppressWarnings("unchecked")
	public List<OfferClaim> getOfferClaim(MerchantUser merchantUser){
		Query query = session.getCurrentSession().createQuery("from OfferClaim where merchantUserByAddedByRef = :merchantUser");
		query.setParameter("merchantUser", merchantUser);
		List<OfferClaim> response = query.list();
		return response;
	}

}
