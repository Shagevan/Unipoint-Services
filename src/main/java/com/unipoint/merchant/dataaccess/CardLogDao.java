package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.CardLog;

public interface CardLogDao {
	public void addCardLog(CardLog cardLog);
	public List<CardLog> getAllCardLog();
	public void deleteCardLog(long cardLogId);
	public CardLog getCardLog(long cardLogId);
}
