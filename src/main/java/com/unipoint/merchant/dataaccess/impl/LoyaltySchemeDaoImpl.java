package com.unipoint.merchant.dataaccess.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.LoyaltySchemeDao;
import com.unipoint.merchant.model.LoyaltyScheme;

@Repository
public class LoyaltySchemeDaoImpl implements LoyaltySchemeDao{
	
	@Autowired
	private SessionFactory session;

	@Override
	public LoyaltyScheme getLoyaltyScheme(long schemeId) {
		return (LoyaltyScheme) session.getCurrentSession().get(LoyaltyScheme.class,
				schemeId);
	}

}
