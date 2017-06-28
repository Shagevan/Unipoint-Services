package com.unipoint.merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unipoint.merchant.dataaccess.LoyaltySchemeDao;
import com.unipoint.merchant.dataaccess.MerchantUserDao;
import com.unipoint.merchant.dataaccess.SubscribeMerchantDao;
import com.unipoint.merchant.dataaccess.UniPointCustomerProfileDao;
import com.unipoint.merchant.model.LoyaltyScheme;
import com.unipoint.merchant.model.MerchantUser;
import com.unipoint.merchant.model.Outlet;
import com.unipoint.merchant.model.SubscribeMerchant;
import com.unipoint.merchant.response.GetCustomerDetailResponse;
import com.unipoint.merchant.response.MerchantUserLoginResponse;
import com.unipoint.merchant.service.MerchantUserService;

@Service
public class MerchantUserServiceImpl implements MerchantUserService{
	
	@Autowired
	private MerchantUserDao merchantUserRepository;
	
	@Autowired
	private SubscribeMerchantDao subscribeMerchantRepository;
	
	@Autowired
	private LoyaltySchemeDao loyaltySchemeRepository;
	
	@Autowired
	private UniPointCustomerProfileDao uniPointCustomerProfileRepository;
	
	@Transactional
	public MerchantUserLoginResponse login(String username, String password){
		
		MerchantUserLoginResponse response = new MerchantUserLoginResponse();
		MerchantUser user = merchantUserRepository.validateLogin(username, password);
		if(user != null){
			Outlet outlet = user.getOutlet();
			response.setMerchantUserName(user.getFirstname());
			response.setMerchantUserName(String.valueOf(user.getMerchantUserId()));
			response.setOutletName(outlet.getOutletname());
			response.setOutletRefId(String.valueOf(outlet.getOutletid()));
			response.setStatus("true");
		}
		else{
			response.setStatus("false");
		}
		return response;
	}
	
	@Transactional
	public GetCustomerDetailResponse getCustomerDetails(String cardNumber){
		GetCustomerDetailResponse response = new GetCustomerDetailResponse();
		SubscribeMerchant subscribeMerchant = subscribeMerchantRepository.getSubscribeMerchantByCardNumber(cardNumber);
		if(subscribeMerchant != null){
			response.setCardNumber(cardNumber);
			response.setCardStatus(subscribeMerchant.getEnabled());
			response.setTotalPoints(String.valueOf(subscribeMerchant.getTotalpoints()));
			String sSchemeRefId = String.valueOf(subscribeMerchant.getSchemerefid());
			LoyaltyScheme loyaltyScheme = loyaltySchemeRepository.getLoyaltyScheme(Long.valueOf(sSchemeRefId));
			if(loyaltyScheme != null){
				response.setSchemeLevel(loyaltyScheme.getSchemeName());
			}
			else{
				response.setError("No Loyalty scheme");
			}
			response.setFirstName(subscribeMerchant.getUnipointCustomerProfile().getCustomerfirstname());
			response.setLastName(subscribeMerchant.getUnipointCustomerProfile().getCustomerlastname());
			response.setPrimaryMobileNumber(subscribeMerchant.getUnipointCustomerProfile().getMobilephonenumberprimary());
			response.setSecondaryMobileNumber(subscribeMerchant.getUnipointCustomerProfile().getMobilephonenumbersecondary());
		}
		else{
			response.setError("Invalid card number");
		}
		
		return response;
	}

}
