package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.Merchant;
import com.unipoint.merchant.model.Outlet;
import com.unipoint.merchant.model.Transaction;
import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface TransactionDao {
	public void addTransaction(Transaction transaction);
	public List<Transaction> getAllTransactios();
	public List<Transaction> getTransactions(Outlet outletRefId);
	public void deleteTransaction(String invoiceNumber);
	public Transaction getTransaction(String invoiceNumber);
	public void updateTransaction(UnipointCustomerProfile unipointCustomerProfile, Merchant merchant, 
			String invoiceNumber, Float points, String type);
}
