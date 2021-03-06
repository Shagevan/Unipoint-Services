package com.unipoint.merchant.model;// Generated Oct 18, 2016 4:59:22 PM by Hibernate Tools 5.1.0.Beta1

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AccessPrivilleges generated by hbm2java
 */
@Entity
@Table(name = "access_privilleges", schema = "unipointmain")
public class AccessPrivilleges implements java.io.Serializable {

	private long privillegeId;
	private MerchantUser merchantUserByLastModifiedByRef;
	private MerchantUser merchantUserByAddedByRef;
	private String contextId;
	private String privillegeSetting;
	private Date addedDateTime;
	private Date lastModifiedDateTime;
	private Serializable lastModifiedFields;
	private Set<MerchantUser> merchantUsers = new HashSet<MerchantUser>(0);

	public AccessPrivilleges() {
	}

	public AccessPrivilleges(long privillegeId) {
		this.privillegeId = privillegeId;
	}

	public AccessPrivilleges(long privillegeId, MerchantUser merchantUserByLastModifiedByRef,
			MerchantUser merchantUserByAddedByRef, String contextId, String privillegeSetting, Date addedDateTime,
			Date lastModifiedDateTime, Serializable lastModifiedFields, Set<MerchantUser> merchantUsers) {
		this.privillegeId = privillegeId;
		this.merchantUserByLastModifiedByRef = merchantUserByLastModifiedByRef;
		this.merchantUserByAddedByRef = merchantUserByAddedByRef;
		this.contextId = contextId;
		this.privillegeSetting = privillegeSetting;
		this.addedDateTime = addedDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
		this.lastModifiedFields = lastModifiedFields;
		this.merchantUsers = merchantUsers;
	}

	@Id

	@Column(name = "privillege_id", unique = true, nullable = false)
	public long getPrivillegeId() {
		return this.privillegeId;
	}

	public void setPrivillegeId(long privillegeId) {
		this.privillegeId = privillegeId;
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
	@JoinColumn(name = "added_by_ref")
	public MerchantUser getMerchantUserByAddedByRef() {
		return this.merchantUserByAddedByRef;
	}

	public void setMerchantUserByAddedByRef(MerchantUser merchantUserByAddedByRef) {
		this.merchantUserByAddedByRef = merchantUserByAddedByRef;
	}

	@Column(name = "context_id")
	public String getContextId() {
		return this.contextId;
	}

	public void setContextId(String contextId) {
		this.contextId = contextId;
	}

	@Column(name = "privillege_setting")
	public String getPrivillegeSetting() {
		return this.privillegeSetting;
	}

	public void setPrivillegeSetting(String privillegeSetting) {
		this.privillegeSetting = privillegeSetting;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "added_date_time", length = 22)
	public Date getAddedDateTime() {
		return this.addedDateTime;
	}

	public void setAddedDateTime(Date addedDateTime) {
		this.addedDateTime = addedDateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date_time", length = 22)
	public Date getLastModifiedDateTime() {
		return this.lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@Column(name = "last_modified_fields")
	public Serializable getLastModifiedFields() {
		return this.lastModifiedFields;
	}

	public void setLastModifiedFields(Serializable lastModifiedFields) {
		this.lastModifiedFields = lastModifiedFields;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessPrivilleges")
	public Set<MerchantUser> getMerchantUsers() {
		return this.merchantUsers;
	}

	public void setMerchantUsers(Set<MerchantUser> merchantUsers) {
		this.merchantUsers = merchantUsers;
	}

}
