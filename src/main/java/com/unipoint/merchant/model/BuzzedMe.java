package com.unipoint.merchant.model;
// Generated Oct 18, 2016 4:59:22 PM by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * BuzzedMe generated by hbm2java
 */
@Entity
@Table(name = "buzzed_me", schema = "unipointmain")
public class BuzzedMe implements java.io.Serializable {

	private long buzzedmeid;
	private Offer offer;
	private UnipointCustomerProfile unipointCustomerProfile;
	
	@NotEmpty
	@Size(min=6,max=50)
	private String description;
	
	private Boolean contacted;

	public BuzzedMe() {
	}

	public BuzzedMe(long buzzedmeid) {
		this.buzzedmeid = buzzedmeid;
	}

	public BuzzedMe(long buzzedmeid, Offer offer, UnipointCustomerProfile unipointCustomerProfile, String description,
			Boolean contacted) {
		this.buzzedmeid = buzzedmeid;
		this.offer = offer;
		this.unipointCustomerProfile = unipointCustomerProfile;
		this.description = description;
		this.contacted = contacted;
	}

	@Id

	@Column(name = "buzzedmeid", unique = true, nullable = false)
	public long getBuzzedmeid() {
		return this.buzzedmeid;
	}

	public void setBuzzedmeid(long buzzedmeid) {
		this.buzzedmeid = buzzedmeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offer_ref_id")
	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unipoint_customer_ref_id")
	public UnipointCustomerProfile getUnipointCustomerProfile() {
		return this.unipointCustomerProfile;
	}

	public void setUnipointCustomerProfile(UnipointCustomerProfile unipointCustomerProfile) {
		this.unipointCustomerProfile = unipointCustomerProfile;
	}

	@Column(name = "description")
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "contacted")
	public Boolean getContacted() {
		return this.contacted;
	}

	public void setContacted(Boolean contacted) {
		this.contacted = contacted;
	}

}