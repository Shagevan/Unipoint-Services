package com.unipoint.merchant.dataaccess.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.UniPointCustomerProfileDao;
import com.unipoint.merchant.model.UnipointCustomerProfile;

@Repository
public class UniPointCustomerProfileDaoImpl implements UniPointCustomerProfileDao {
	
	@Autowired
	private SessionFactory session;
	
	public void addUniPointCustomerProfile(UnipointCustomerProfile uniPointCustomer) {
		session.getCurrentSession().save(uniPointCustomer);
	}
	
	@SuppressWarnings("unchecked")
	public List<UnipointCustomerProfile> getAllUniPointCustomerProfile() {
		return session.getCurrentSession().createQuery("from unipoint_customer_profile").list();
	}

	public void deleteUniPointCustomerProfile(int uniPointCustomerId) {
		session.getCurrentSession().delete(getUniPointCustomerProfile(uniPointCustomerId));
	}

	public UnipointCustomerProfile getUniPointCustomerProfile(int uniPointCustomerId) {
		return (UnipointCustomerProfile) session.getCurrentSession().get(UnipointCustomerProfile.class,
				uniPointCustomerId);
	}
	
	@SuppressWarnings("unchecked")
	public UnipointCustomerProfile getUniPointCustomerByMobile(String mobileNumber) {
		
		//String hql = "from UnipointCustomerProfile where mobilephonenumberprimary= :mobileNumber "
		//		+ "or mobilephonenumbersecondary= :mobileNumber";
		
		String hqlString = "from UnipointCustomerProfile where mobilephonenumbersecondary= :mobileNumber"
				+ "or mobilephonenumberprimary= :mobileNumber";
		
		Query query=session.getCurrentSession().createQuery(hqlString);
		query.setParameter("mobileNumber", mobileNumber);
		UnipointCustomerProfile result = (UnipointCustomerProfile) query.uniqueResult();
		return result;
	}

}
