package com.unipoint.merchant.dataaccess.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unipoint.merchant.dataaccess.CardLogDao;
import com.unipoint.merchant.model.CardLog;

@Repository
public class CardLogDaoImpl implements CardLogDao{

	@Autowired
	private SessionFactory session;
	
	public void addCardLog(CardLog cardLog) {
		session.getCurrentSession().save(cardLog);
	}
	
	@SuppressWarnings("unchecked")
	public List<CardLog> getAllCardLog() {
		return session.getCurrentSession().createQuery("from point_conversion").list();
	}

	public void deleteCardLog(int cardLogId) {
		session.getCurrentSession().delete(getCardLog(cardLogId));
	}

	public CardLog getCardLog(int cardLogId) {
		return (CardLog) session.getCurrentSession().get(CardLog.class,
				cardLogId);
	}
}
