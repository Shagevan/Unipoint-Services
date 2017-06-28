package com.unipoint.merchant.model;
// Generated Oct 18, 2016 4:59:22 PM by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BuyPoint generated by hbm2java
 */
@Entity
@Table(name = "buy_point", schema = "unipointmain")
public class BuyPoint implements java.io.Serializable {

	private long buyPointsId;
	private Merchant merchant;
	private MerchantUser merchantUserByAddedByRef;
	private MerchantUser merchantUserByLastModifiedByRef;
	private Outlet outlet;
	private UnipointCustomerProfile unipointCustomerProfile;
	private Double paidAmount;
	private String currencyCode;
	private String dateTime;
	private Double pointsReceived;
	private Double percentageApplied;
	private String addedDateTime;
	private String lastModifiedDateTime;
	private String lastModifiedFields;

	public BuyPoint() {
	}

	public BuyPoint(long buyPointsId, Merchant merchant, UnipointCustomerProfile unipointCustomerProfile) {
		this.buyPointsId = buyPointsId;
		this.merchant = merchant;
		this.unipointCustomerProfile = unipointCustomerProfile;
	}

	public BuyPoint(long buyPointsId, Merchant merchant, MerchantUser merchantUserByAddedByRef,
			MerchantUser merchantUserByLastModifiedByRef, Outlet outlet,
			UnipointCustomerProfile unipointCustomerProfile, Double paidAmount, String currencyCode, String dateTime,
			Double pointsReceived, Double percentageApplied, String addedDateTime, String lastModifiedDateTime,
			String lastModifiedFields) {
		this.buyPointsId = buyPointsId;
		this.merchant = merchant;
		this.merchantUserByAddedByRef = merchantUserByAddedByRef;
		this.merchantUserByLastModifiedByRef = merchantUserByLastModifiedByRef;
		this.outlet = outlet;
		this.unipointCustomerProfile = unipointCustomerProfile;
		this.paidAmount = paidAmount;
		this.currencyCode = currencyCode;
		this.dateTime = dateTime;
		this.pointsReceived = pointsReceived;
		this.percentageApplied = percentageApplied;
		this.addedDateTime = addedDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
		this.lastModifiedFields = lastModifiedFields;
	}

	@Id
	@Column(name = "buy_points_id", unique = true, nullable = false)
	public long getBuyPointsId() {
		return this.buyPointsId;
	}

	public void setBuyPointsId(long buyPointsId) {
		this.buyPointsId = buyPointsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merchant_ref_id", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "added_by_ref")
	public MerchantUser getMerchantUserByAddedByRef() {
		return this.merchantUserByAddedByRef;
	}

	public void setMerchantUserByAddedByRef(MerchantUser merchantUserByAddedByRef) {
		this.merchantUserByAddedByRef = merchantUserByAddedByRef;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "last_modified_by_ref")
	public MerchantUser getMerchantUserByLastModifiedByRef() {
		return this.merchantUserByLastModifiedByRef;
	}

	public void setMerchantUserByLastModifiedByRef(MerchantUser merchantUserByLastModifiedByRef) {
		this.merchantUserByLastModifiedByRef = merchantUserByLastModifiedByRef;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "outlet_ref_id")
	public Outlet getOutlet() {
		return this.outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unipoint_customer_ref_id", nullable = false)
	public UnipointCustomerProfile getUnipointCustomerProfile() {
		return this.unipointCustomerProfile;
	}

	public void setUnipointCustomerProfile(UnipointCustomerProfile unipointCustomerProfile) {
		this.unipointCustomerProfile = unipointCustomerProfile;
	}

	@Column(name = "paid_amount", precision = 17, scale = 17)
	public Double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Column(name = "currency_code")
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name = "date_time", length = 100)
	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "points_received", precision = 17, scale = 17)
	public Double getPointsReceived() {
		return this.pointsReceived;
	}

	public void setPointsReceived(Double pointsReceived) {
		this.pointsReceived = pointsReceived;
	}

	@Column(name = "percentage_applied", precision = 17, scale = 17)
	public Double getPercentageApplied() {
		return this.percentageApplied;
	}

	public void setPercentageApplied(Double percentageApplied) {
		this.percentageApplied = percentageApplied;
	}

	@Column(name = "added_date_time", length = 50)
	public String getAddedDateTime() {
		return this.addedDateTime;
	}

	public void setAddedDateTime(String addedDateTime) {
		this.addedDateTime = addedDateTime;
	}

	@Column(name = "last_modified_date_time", length = 50)
	public String getLastModifiedDateTime() {
		return this.lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(String lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@Column(name = "last_modified_fields")
	public String getLastModifiedFields() {
		return this.lastModifiedFields;
	}

	public void setLastModifiedFields(String lastModifiedFields) {
		this.lastModifiedFields = lastModifiedFields;
	}

}
