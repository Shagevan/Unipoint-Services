package com.unipoint.merchant.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"Merchant\".\"MERCHANT_CUSTOMER\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MerchantCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"CustomerID\"")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerID;
	
	@Column(name = "\"RegistrationDateTime\"")
	private Date registrationDateTime;

	@Column(name = "\"ContactNumber\"")
	private String contactNumber;

	@Column(name = "\"MobilePhoneNum\"")
	private int mobilePhoneNumber;

	@Column(name = "\"CustomerFirstName\"")
	private String customerFirstName;
	
	@Column(name = "\"CustomerLastName\"")
	private String customerLastName;
	
	@Column(name = "\"Gender\"")
	private String gender;
	
	@Column(name = "\"PostalAddress\"")
	private String postalAddress;
	
	@Column(name = "\"EmailAddress\"")
	private String emailAddress;
	
	@Column(name = "\"Enabled\"")
	private String enabled;
	
	@Column(name = "\"SchemeRefID\"")
	private int schemeRefID;
	
	@Column(name = "\"Points\"")
	private int points;

	@Column(name = "\"CardNumber\"")
	private String cardNumber;
	
	@Column(name = "\"AccountNumber\"")
	private String accountNumber;

	@Column(name = "\"RedeemPoints\"")
	private int redeemPoints;
	
	public MerchantCustomer(){
		
	}

	/**
	 * @param customerID
	 * @param registrationDateTime
	 * @param contactNumber
	 * @param mobilePhoneNumber
	 * @param customerFirstName
	 * @param customerLastName
	 * @param gender
	 * @param postalAddress
	 * @param emailAddress
	 * @param enabled
	 * @param schemeRefID
	 * @param points
	 * @param cardNumber
	 * @param accountNumber
	 * @param redeemPoints
	 */
	public MerchantCustomer(int customerID, Date registrationDateTime,
			String contactNumber, int mobilePhoneNumber,
			String customerFirstName, String customerLastName, String gender,
			String postalAddress, String emailAddress, String enabled,
			int schemeRefID, int points, String cardNumber,
			String accountNumber, int redeemPoints) {
		this.customerID = customerID;
		this.registrationDateTime = registrationDateTime;
		this.contactNumber = contactNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.gender = gender;
		this.postalAddress = postalAddress;
		this.emailAddress = emailAddress;
		this.enabled = enabled;
		this.schemeRefID = schemeRefID;
		this.points = points;
		this.cardNumber = cardNumber;
		this.accountNumber = accountNumber;
		this.redeemPoints = redeemPoints;
	}

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the registrationDateTime
	 */
	public Date getRegistrationDateTime() {
		return registrationDateTime;
	}

	/**
	 * @param registrationDateTime the registrationDateTime to set
	 */
	public void setRegistrationDateTime(Date registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the mobilePhoneNumber
	 */
	public int getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * @param mobilePhoneNumber the mobilePhoneNumber to set
	 */
	public void setMobilePhoneNumber(int mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the postalAddress
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the schemeRefID
	 */
	public int getSchemeRefID() {
		return schemeRefID;
	}

	/**
	 * @param schemeRefID the schemeRefID to set
	 */
	public void setSchemeRefID(int schemeRefID) {
		this.schemeRefID = schemeRefID;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the redeemPoints
	 */
	public int getRedeemPoints() {
		return redeemPoints;
	}

	/**
	 * @param redeemPoints the redeemPoints to set
	 */
	public void setRedeemPoints(int redeemPoints) {
		this.redeemPoints = redeemPoints;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

