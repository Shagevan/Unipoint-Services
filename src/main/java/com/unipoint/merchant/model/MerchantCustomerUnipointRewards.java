package com.unipoint.merchant.model;
// Generated Oct 18, 2016 4:59:22 PM by Hibernate Tools 5.1.0.Beta1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MerchantCustomerUnipointRewards generated by hbm2java
 */
@Entity
@Table(name = "merchant_customer_unipoint_rewards", schema = "unipointmain")
public class MerchantCustomerUnipointRewards implements java.io.Serializable {

	private MerchantCustomerUnipointRewardsId id;
	private MerchantUser merchantUserByAddedByRef;
	private MerchantUser merchantUserByLastModifiedByRef;
	private PointRewards pointRewards;
	private String addedDateTime;
	private String lastModifiedDateTime;
	private String lastModifiedFields;

	public MerchantCustomerUnipointRewards() {
	}

	public MerchantCustomerUnipointRewards(MerchantCustomerUnipointRewardsId id, PointRewards pointRewards) {
		this.id = id;
		this.pointRewards = pointRewards;
	}

	public MerchantCustomerUnipointRewards(MerchantCustomerUnipointRewardsId id, MerchantUser merchantUserByAddedByRef,
			MerchantUser merchantUserByLastModifiedByRef, PointRewards pointRewards, String addedDateTime,
			String lastModifiedDateTime, String lastModifiedFields) {
		this.id = id;
		this.merchantUserByAddedByRef = merchantUserByAddedByRef;
		this.merchantUserByLastModifiedByRef = merchantUserByLastModifiedByRef;
		this.pointRewards = pointRewards;
		this.addedDateTime = addedDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
		this.lastModifiedFields = lastModifiedFields;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mechantCustomerId", column = @Column(name = "mechant_customer_id", nullable = false)),
			@AttributeOverride(name = "pointsRewardsId", column = @Column(name = "points_rewards_id", nullable = false)) })
	public MerchantCustomerUnipointRewardsId getId() {
		return this.id;
	}

	public void setId(MerchantCustomerUnipointRewardsId id) {
		this.id = id;
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
	@JoinColumn(name = "points_rewards_id", nullable = false, insertable = false, updatable = false)
	public PointRewards getPointRewards() {
		return this.pointRewards;
	}

	public void setPointRewards(PointRewards pointRewards) {
		this.pointRewards = pointRewards;
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
