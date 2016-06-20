package com.unipoint.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unipoint.merchant.dataaccess.MerchantCustomerDao;
import com.unipoint.merchant.model.MerchantCustomer;
import com.unipoint.merchant.service.MerchantCustomerService;

@Service
public class MerchantCustomerServiceImpl implements MerchantCustomerService {

	@Autowired
	private MerchantCustomerDao merchantCustomerDao;
	
	@Transactional
	public MerchantCustomer searchCustomer(String firstName, String lastName,
			String address, int mobileNo) {
		return merchantCustomerDao.searchCustomer(firstName, lastName, address, mobileNo);
	}

	@Transactional
	public List<MerchantCustomer> getAllCustomers() {
		return merchantCustomerDao.getAllCustomers();
	}

	@Transactional
	public MerchantCustomer getCustomer(int accountNo) {
		return merchantCustomerDao.getCustomer(accountNo);
	}

}
