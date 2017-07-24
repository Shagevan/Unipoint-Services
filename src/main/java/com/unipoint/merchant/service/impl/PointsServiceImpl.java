package com.unipoint.merchant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unipoint.merchant.dataaccess.CardLogDao;
import com.unipoint.merchant.dataaccess.LoyaltySchemeDao;
import com.unipoint.merchant.dataaccess.MerchantUserDao;
import com.unipoint.merchant.dataaccess.PointConversionDao;
import com.unipoint.merchant.dataaccess.PointRewardsDao;
import com.unipoint.merchant.dataaccess.SubscribeMerchantDao;
import com.unipoint.merchant.dataaccess.TransactionDao;
import com.unipoint.merchant.dataaccess.UniPointCustomerProfileDao;
import com.unipoint.merchant.model.CardLog;
import com.unipoint.merchant.model.LoyaltyScheme;
import com.unipoint.merchant.model.MerchantUser;
import com.unipoint.merchant.model.PointConversion;
import com.unipoint.merchant.model.PointRewards;
import com.unipoint.merchant.model.SubscribeMerchant;
import com.unipoint.merchant.model.Transaction;
import com.unipoint.merchant.model.UnipointCustomerProfile;
import com.unipoint.merchant.response.TransactionHistory;
import com.unipoint.merchant.response.TransctionHistoryResponse;
import com.unipoint.merchant.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService{
	
	@Autowired
	private PointRewardsDao pointsRewardsRepository;
	
	@Autowired
	private CardLogDao cardLogRepository;
	
	@Autowired
	private PointConversionDao pointConversionRepository;
	
	@Autowired
	private TransactionDao transactionRepository;
	
	@Autowired
	private UniPointCustomerProfileDao uniPointCustomerProfileRepository;
	
	@Autowired
	private SubscribeMerchantDao subscribeMerchantRepository;
	
	@Autowired
	private LoyaltySchemeDao loyaltySchemeRepository;
	
	@Autowired
	private MerchantUserDao merchantUserRepository;
	
	@Transactional
	public TransctionHistoryResponse addPointsFromInvoice(String customerMobileNumber,String invoiceNumber,String merchantUserRefId) {
		TransctionHistoryResponse response = new TransctionHistoryResponse();
		List<TransactionHistory> transactionHistories = new ArrayList<>();
		UnipointCustomerProfile user = uniPointCustomerProfileRepository.getUniPointCustomerByMobile(customerMobileNumber);
		if(user != null){
			Transaction transaction = transactionRepository.getTransaction(invoiceNumber);
			if(transaction != null){
				MerchantUser merchantUser = merchantUserRepository.getMerchantUserById(Long.valueOf(merchantUserRefId));
				if(merchantUser != null){
					PointConversion pointConversion = pointConversionRepository.getPointConvrsion(merchantUser.getMerchant());
					if(pointConversion != null){
						int points = (int) (transaction.getTotalBillValue() * pointConversion.getPointsForCurrencyValue());
						String sPoints = String.valueOf(points);
						
						PointRewards pointRewards = new PointRewards();
						pointRewards.setUnipointCustomerProfile(user);
						pointRewards.setPoints(Double.valueOf(sPoints));
						pointRewards.setDescription("Addition of points");
						pointRewards.setAwardedByRefId(Long.valueOf(merchantUserRefId));
						
						CardLog cardLog = new CardLog();
						cardLog.setActivity("Points Addition");
						cardLog.setActivityDescription("Point Addition");
						cardLog.setUnipointCustomerProfile(user);
						cardLog.setMerchant(merchantUser.getMerchant());
						
						transactionRepository.updateTransaction(user, merchantUser.getMerchant(), invoiceNumber, Float.valueOf(sPoints), "Award");
						pointsRewardsRepository.addPointRewards(pointRewards);
						cardLogRepository.addCardLog(cardLog);
						subscribeMerchantRepository.updatePoints("Add", user, merchantUser.getMerchant(), Double.valueOf(sPoints));
						List<Transaction> transactions = transactionRepository.getTransactions(merchantUser.getOutlet());
						if(transactions != null){
							for (Transaction object : transactions) {
								TransactionHistory obj = new TransactionHistory();
								obj.setPhoneNumber(object.getUnipointCustomerProfile().getMobilephonenumberprimary());
								obj.setInvoiceNumber(object.getInvoiceNumber());
								obj.setPointsAwarded(String.valueOf(object.getPointsAwarded()));
								obj.setTransactionDateTime(object.getDateTime());
								if(object.getSubscribeMerchant() != null){
									LoyaltyScheme loyaltyScheme = loyaltySchemeRepository.getLoyaltyScheme(object.getSubscribeMerchant().getSchemerefid());
									if(loyaltyScheme != null){
										obj.setLoyalityLevel(loyaltyScheme.getSchemeName());
									}
									else{
										response.setError("Loyalty Scheme not found");
									}
								}
								transactionHistories.add(obj);
							}
							response.setMessage("Successfull");
							response.setTransactionHistory(transactionHistories);
							response.setError(null);
						}
						else{
							response.setError("failed");
						}
					}
					else{
						response.setError("No conversion rate found");
					}
				}
				else{
					response.setError("No Merchant user found");
				}

			}
			else{
				response.setError("Transaction not found");
			}
		}
		else{
			response.setError("User not found");
		}
		
		return response;
	}
	
	@Transactional
	public TransctionHistoryResponse addPointsFromAmount(String customerMobileNumber,String billAmount,String merchantUserRefId, String transactionType) {
		TransctionHistoryResponse response = new TransctionHistoryResponse();
		List<TransactionHistory> transactionHistories = new ArrayList<>();
		UnipointCustomerProfile user = uniPointCustomerProfileRepository.getUniPointCustomerByMobile(customerMobileNumber);
		if(user != null){
			MerchantUser merchantUser = merchantUserRepository.getMerchantUserById(Long.valueOf(merchantUserRefId));
			if(merchantUser != null){
				PointConversion pointConversion = pointConversionRepository.getPointConvrsion(merchantUser.getMerchant());
				if(pointConversion != null){
					Float points = Float.valueOf(billAmount) * pointConversion.getPointsForCurrencyValue();
					String sPoints = String.valueOf(points);
					
					PointRewards pointRewards = new PointRewards();
					pointRewards.setUnipointCustomerProfile(user);
					pointRewards.setPoints(Double.valueOf(sPoints));
					pointRewards.setDescription("Addition of points");
					pointRewards.setAwardedByRefId(Long.valueOf(merchantUserRefId));
					
					CardLog cardLog = new CardLog();
					cardLog.setActivity("Points Addition");
					cardLog.setActivityDescription("Point Addition");
					cardLog.setUnipointCustomerProfile(user);
					cardLog.setMerchant(merchantUser.getMerchant());
					
					Transaction transaction = new Transaction();
					transaction.setSubscribeMerchant(subscribeMerchantRepository.getSubscribeMerchant(user,merchantUser.getMerchant()));
					transaction.setOutlet(merchantUser.getOutlet());
					transaction.setTotalBillValue(Double.valueOf(billAmount));
					transaction.setPointsAwarded(points);
					transaction.setUnipointCustomerProfile(user);
					transaction.setTransactionType(transactionType);
					
					transactionRepository.addTransaction(transaction);
					pointsRewardsRepository.addPointRewards(pointRewards);
					cardLogRepository.addCardLog(cardLog);
					subscribeMerchantRepository.updatePoints("Add", user, merchantUser.getMerchant(), Double.valueOf(sPoints));
					List<Transaction> transactions = transactionRepository.getTransactions(merchantUser.getOutlet());
					if(transactions != null){
						for (Transaction object : transactions) {
							TransactionHistory obj = new TransactionHistory();
							obj.setPhoneNumber(object.getUnipointCustomerProfile().getMobilephonenumberprimary());
							obj.setInvoiceNumber(object.getInvoiceNumber());
							obj.setPointsAwarded(String.valueOf(object.getPointsAwarded()));
							obj.setTransactionDateTime(object.getDateTime());
							if(object.getSubscribeMerchant() != null){
								LoyaltyScheme loyaltyScheme = loyaltySchemeRepository.getLoyaltyScheme(object.getSubscribeMerchant().getSchemerefid());
								if(loyaltyScheme != null){
									obj.setLoyalityLevel(loyaltyScheme.getSchemeName());
								}
								else{
									response.setError("Loyalty Scheme not found");
								}
							}
							transactionHistories.add(obj);
						}
						response.setMessage("Successfull");
						response.setTransactionHistory(transactionHistories);
						response.setError(null);
					}
					else{
						response.setError("failed");
					}
					
				}
				else{
					response.setError("No conversion rate found");
				}
			}
			else{
				response.setError("No Merchant user found");
			}

		}
		else{
			response.setError("User Not found");
		}
		
		return response;
	}
	
	
	@Transactional
	public TransctionHistoryResponse redeemPoints(String customerMobileNumber,String billValue, String points, String merchantUserRefId, String transactionType){
		TransctionHistoryResponse response = new TransctionHistoryResponse();
		List<TransactionHistory> transactionHistories = new ArrayList<>();
		Double reducedAmount;
		Double updatedBillValue;
		MerchantUser merchantUser = merchantUserRepository.getMerchantUserById(Long.valueOf(merchantUserRefId));
		if(merchantUser != null){
			PointConversion pointConversion = pointConversionRepository.getPointConvrsion(merchantUser.getMerchant());
			if(pointConversion != null){
				reducedAmount = Double.valueOf(points) / pointConversion.getPointsForCurrencyValue();
				updatedBillValue = Double.valueOf(billValue) - reducedAmount;
				UnipointCustomerProfile user = uniPointCustomerProfileRepository.getUniPointCustomerByMobile(customerMobileNumber);
			if(user != null){
				SubscribeMerchant subscribeMerchant = subscribeMerchantRepository.getSubscribeMerchant(user,merchantUser.getMerchant());
				if(Double.valueOf(subscribeMerchant.getTotalpoints().toString()) >= Double.valueOf(points)){
					PointRewards pointRewards = new PointRewards();
					pointRewards.setUnipointCustomerProfile(user);
					pointRewards.setPoints(Double.valueOf(points));
					pointRewards.setDescription("Redeemption of points");
					pointRewards.setAwardedByRefId(Long.valueOf(merchantUserRefId));
					
					CardLog cardLog = new CardLog();
					cardLog.setActivity("Points Redeemption");
					cardLog.setActivityDescription("Point Redeemption");
					cardLog.setUnipointCustomerProfile(user);
					cardLog.setMerchant(merchantUser.getMerchant());
					
					Transaction transaction = new Transaction();
					transaction.setPointsRedeemed(Float.valueOf(points));
					transaction.setSubscribeMerchant(subscribeMerchant);
					transaction.setOutlet(merchantUser.getOutlet());
					transaction.setTotalBillValue(updatedBillValue);
					transaction.setUnipointCustomerProfile(user);
					transaction.setTransactionType(transactionType);
					
					pointsRewardsRepository.addPointRewards(pointRewards);
					cardLogRepository.addCardLog(cardLog);
					subscribeMerchantRepository.updatePoints("Redeem", user, merchantUser.getMerchant(),  Double.valueOf(points));
					transactionRepository.addTransaction(transaction);
					List<Transaction> transactions = transactionRepository.getTransactions(merchantUser.getOutlet());
					if(transactions != null){
						for (Transaction object : transactions) {
							TransactionHistory obj = new TransactionHistory();
							obj.setPhoneNumber(object.getUnipointCustomerProfile().getMobilephonenumberprimary());
							obj.setInvoiceNumber(object.getInvoiceNumber());
							obj.setPointsAwarded(String.valueOf(object.getPointsAwarded()));
							obj.setTransactionDateTime(object.getDateTime());
							if(object.getSubscribeMerchant() != null){
								LoyaltyScheme loyaltyScheme = loyaltySchemeRepository.getLoyaltyScheme(object.getSubscribeMerchant().getSchemerefid());
								if(loyaltyScheme != null){
									obj.setLoyalityLevel(loyaltyScheme.getSchemeName());
								}
								else{
									response.setError("Loyalty Scheme not found");
								}
							}
							transactionHistories.add(obj);
						}
						response.setMessage(String.valueOf(updatedBillValue));
						response.setTransactionHistory(transactionHistories);
						response.setError(null);
					}
					else{
						response.setError("failed");
					}
				}
				else{
					response.setError("Not enough points to redeem");
				}
			}
			else{
				response.setError("User Not found");
			}
		}
			else{
				response.setError("Conversion rate Not found");
			}
		}
		else{
			response.setError("Merchant user Not found");
		}
		
		return response;
	}
	
	@Transactional
	public TransctionHistoryResponse getTransactionHistory(String merchantUserRefId){
		TransctionHistoryResponse response = new TransctionHistoryResponse();
		List<TransactionHistory> transactionHistories = new ArrayList<>();
		MerchantUser merchantUser = merchantUserRepository.getMerchantUserById(Long.valueOf(merchantUserRefId));
		if(merchantUser != null){
			List<Transaction> transactions = transactionRepository.getTransactions(merchantUser.getOutlet());
			if(transactions != null){
				for (Transaction object : transactions) {
					TransactionHistory obj = new TransactionHistory();
					obj.setPhoneNumber(object.getUnipointCustomerProfile().getMobilephonenumberprimary());
					obj.setInvoiceNumber(object.getInvoiceNumber());
					obj.setPointsAwarded(String.valueOf(object.getPointsAwarded()));
					obj.setTransactionDateTime(object.getDateTime());
					if(object.getSubscribeMerchant() != null){
						LoyaltyScheme loyaltyScheme = loyaltySchemeRepository.getLoyaltyScheme(object.getSubscribeMerchant().getSchemerefid());
						if(loyaltyScheme != null){
							obj.setLoyalityLevel(loyaltyScheme.getSchemeName());
						}
						else{
							response.setError("Loyalty Scheme not found");
						}
					}
					transactionHistories.add(obj);
				}
				response.setMessage("Successfull");
				response.setTransactionHistory(transactionHistories);
				response.setError(null);
			}
			else{
				response.setError("failed");
			}
		}
		else{
			response.setError("Merchant user not found");
		}
		
		return response;
	}

}
