package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.CardLog;

public interface CardLogDao {
	public void addCardLog(CardLog cardLog);
	public List<CardLog> getAllCardLog();
	public void deleteCardLog(int cardLogId);
	public CardLog getCardLog(int cardLogId);
}
