package com.unipoint.merchant.dataaccess.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.OfferDao;
import com.unipoint.merchant.model.Offer;

@Repository
public class OfferDaoImpl implements OfferDao{
	
	@Autowired
	private SessionFactory session;
	
	public Offer getOfferByOfferRefId(long offerRefId){
		return (Offer) session.getCurrentSession().get(Offer.class,offerRefId);
	}

}
