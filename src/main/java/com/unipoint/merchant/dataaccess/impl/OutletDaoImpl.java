package com.unipoint.merchant.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.OutletDao;
import com.unipoint.merchant.model.Outlet;

@Repository
public class OutletDaoImpl implements OutletDao{

	@Autowired
	private SessionFactory session;

	@Override
	public void addOutlet(Outlet outlet) {
		session.getCurrentSession().save(outlet);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Outlet> getAllOutlets() {
		return session.getCurrentSession().createQuery("from Outlet").list();
	}

	@Override
	public void deleteOutlet(int outletID) {
		session.getCurrentSession().delete(getOutlet(outletID));
		
	}

	@Override
	public Outlet getOutlet(int outletID) {
		return (Outlet) session.getCurrentSession().get(Outlet.class,
				outletID);
	}
}
