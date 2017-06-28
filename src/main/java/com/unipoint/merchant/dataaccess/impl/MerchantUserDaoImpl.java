package com.unipoint.merchant.dataaccess.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.MerchantUserDao;
import com.unipoint.merchant.model.MerchantUser;
import com.unipoint.merchant.model.SubscribeMerchant;

@Repository
public class MerchantUserDaoImpl implements MerchantUserDao{
	
	@Autowired
	private SessionFactory session;

	public MerchantUser validateLogin(String userName, String password){
		Query query=session.getCurrentSession().createQuery("from MerchantUser where username= :username and password= :password");
		query.setParameter("username", userName);
		query.setParameter("password", password);
		MerchantUser result = (MerchantUser) query.uniqueResult();
		return result;
	}

	@Override
	public MerchantUser getMerchantUserById(int merchantUserRefId) {
		return (MerchantUser) session.getCurrentSession().get(MerchantUser.class,
				merchantUserRefId);
	}
}
