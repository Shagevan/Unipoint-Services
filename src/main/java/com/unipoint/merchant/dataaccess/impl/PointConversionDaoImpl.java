package com.unipoint.merchant.dataaccess.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.PointConversionDao;
import com.unipoint.merchant.model.Merchant;
import com.unipoint.merchant.model.PointConversion;
import com.unipoint.merchant.model.UnipointCustomerProfile;

@Repository
public class PointConversionDaoImpl implements PointConversionDao{

	@Autowired
	private SessionFactory session;
	
	public void addPointConvrsion(PointConversion pointConversion) {
		session.getCurrentSession().save(pointConversion);
	}
	
	@SuppressWarnings("unchecked")
	public List<PointConversion> getAllPointConvrsions() {
		return session.getCurrentSession().createQuery("from point_conversion").list();
	}

	public void deletePointConvrsion(Merchant merchant) {
		session.getCurrentSession().delete(getPointConvrsion(merchant));
	}

	public PointConversion getPointConvrsion(Merchant merchant) {
		String hqlString = "from PointConversion where merchant= :merchant";
		Query query=session.getCurrentSession().createQuery(hqlString);
		query.setParameter("merchant", merchant);
		PointConversion result = (PointConversion) query.uniqueResult();
		return result;
	}
}
