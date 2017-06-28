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
 * PasswordChangeRequest generated by hbm2java
 */
@Entity
@Table(name = "password_change_request", schema = "unipointmain")
public class PasswordChangeRequest implements java.io.Serializable {

	private String hashId;
	private UnipointCustomerProfile unipointCustomerProfile;
	private String dateTimeRequested;
	private String extraField;

	public PasswordChangeRequest() {
	}

	public PasswordChangeRequest(String hashId, String dateTimeRequested) {
		this.hashId = hashId;
		this.dateTimeRequested = dateTimeRequested;
	}

	public PasswordChangeRequest(String hashId, UnipointCustomerProfile unipointCustomerProfile,
			String dateTimeRequested, String extraField) {
		this.hashId = hashId;
		this.unipointCustomerProfile = unipointCustomerProfile;
		this.dateTimeRequested = dateTimeRequested;
		this.extraField = extraField;
	}

	@Id

	@Column(name = "hash_id", unique = true, nullable = false)
	public String getHashId() {
		return this.hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unipoint_customer_ref_id")
	public UnipointCustomerProfile getUnipointCustomerProfile() {
		return this.unipointCustomerProfile;
	}

	public void setUnipointCustomerProfile(UnipointCustomerProfile unipointCustomerProfile) {
		this.unipointCustomerProfile = unipointCustomerProfile;
	}

	@Column(name = "date_time_requested", nullable = false, length = 200)
	public String getDateTimeRequested() {
		return this.dateTimeRequested;
	}

	public void setDateTimeRequested(String dateTimeRequested) {
		this.dateTimeRequested = dateTimeRequested;
	}

	@Column(name = "extra_field")
	public String getExtraField() {
		return this.extraField;
	}

	public void setExtraField(String extraField) {
		this.extraField = extraField;
	}

}