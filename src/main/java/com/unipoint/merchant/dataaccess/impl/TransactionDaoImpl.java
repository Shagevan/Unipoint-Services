package com.unipoint.merchant.dataaccess.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.TransactionDao;
import com.unipoint.merchant.model.Merchant;
import com.unipoint.merchant.model.Outlet;
import com.unipoint.merchant.model.SubscribeMerchant;
import com.unipoint.merchant.model.Transaction;
import com.unipoint.merchant.model.UnipointCustomerProfile;

import org.hibernate.Query;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private SessionFactory session;
	
	public void addTransaction(Transaction transaction) {
		session.getCurrentSession().save(transaction);
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getAllTransactios() {
		return session.getCurrentSession().createQuery("from transaction").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactions(Merchant merchantRefId, Outlet outletRefId) {
		Query query = session.getCurrentSession().createQuery("from Transaction where outlet = :outletRefId and "
				+ "merchant = :merchantRefId");
		query.setParameter("merchantRefId", merchantRefId);
		query.setParameter("outletRefId", outletRefId);
		List<Transaction> response = query.list();
		return response;
	}

	public void deleteTransaction(int invoiceNumber) {
		session.getCurrentSession().delete(getTransaction(invoiceNumber));
	}

	public Transaction getTransaction(int invoiceNumber) {
		return (Transaction) session.getCurrentSession().get(Transaction.class,
				invoiceNumber);
	}
	
	public void updateTransaction(UnipointCustomerProfile unipointCustomerProfile, int invoiceNumber, Float points, String type) {
		
		Query hqlquery=session.getCurrentSession().createQuery("from SubscribeMerchant where unipointCustomerProfile= :unipointCustomerProfile");
		hqlquery.setParameter("unipointCustomerProfile", unipointCustomerProfile);
		SubscribeMerchant result = (SubscribeMerchant) hqlquery.uniqueResult();
		
		if(result.getEnabled().equals("false")){
			Query query = session.getCurrentSession().createQuery("update SubscribeMerchant set enabled = :points" +
					" where unipointCustomerProfile = :unipointCustomerProfile");
			query.setParameter("enabled", "true");
			query.setParameter("unipointCustomerProfile", unipointCustomerProfile);
			query.executeUpdate();
		}
		
		if(type.equals("Award")){
			Query query = session.getCurrentSession().createQuery("update Transaction set pointsAwarded = :points" +
					" where invoiceNumber = :invoiceNumber");
			query.setParameter("invoiceNumber", invoiceNumber);
			query.setParameter("points", points);
			query.executeUpdate();
		}
		else if(type.equals("Redeemption")){
				Query query = session.getCurrentSession().createQuery("update Transaction set pointsRedeemed = :points" +
						" where invoiceNumber = :invoiceNumber");
				query.setParameter("invoiceNumber", invoiceNumber);
				query.setParameter("points", points);
				query.executeUpdate();
		}
		
	}

}
