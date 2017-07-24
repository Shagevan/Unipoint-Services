package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.Outlet;

public interface OutletDao {   
	public void addOutlet(Outlet outlet);
	public Outlet getOutlet(long outletID);
	public void deleteOutlet(long outletID);
	public List<Outlet> getAllOutlets();
}
