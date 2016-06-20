package com.unipoint.merchant.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.MerchantCustomerDao;
import com.unipoint.merchant.model.MerchantCustomer;

@Repository
public class MerchantCustomerDaoImpl implements MerchantCustomerDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public MerchantCustomer searchCustomer(String firstName, String lastName,
			String address, int mobileNo) {
		String queryString = "from MerchantCustomer where (customerFirstName LIKE '"+firstName+"' and "+
				"customerLastName LIKE '"+lastName+"') "+"or postalAddress LIKE '"+address+"' "+"or mobilePhoneNumber = "+mobileNo;
		List<MerchantCustomer> result = session.getCurrentSession().createQuery(queryString).list();
		
		if(result.size()==1)
			return (MerchantCustomer) result.get(0);
		else
			return null;
	}

	@Override
	public List<MerchantCustomer> getAllCustomers() {
		return session.getCurrentSession().createQuery("from MerchantCustomer").list();
	}

	@Override
	public MerchantCustomer getCustomer(int accountNo) {
		return (MerchantCustomer) session.getCurrentSession().get(MerchantCustomer.class,
				accountNo);
	}

}
