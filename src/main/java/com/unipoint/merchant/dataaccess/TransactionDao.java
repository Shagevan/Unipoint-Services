package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.Merchant;
import com.unipoint.merchant.model.Outlet;
import com.unipoint.merchant.model.Transaction;
import com.unipoint.merchant.model.UnipointCustomerProfile;

public interface TransactionDao {
	public void addTransaction(Transaction transaction);
	public List<Transaction> getAllTransactios();
	public List<Transaction> getTransactions(Merchant merchantRefId, Outlet outletRefId);
	public void deleteTransaction(int invoiceNumber);
	public Transaction getTransaction(int invoiceNumber);
	public void updateTransaction(UnipointCustomerProfile unipointCustomerProfile, int invoiceNumber, Float points, String type);
}
