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
 * OfferReservation generated by hbm2java
 */
@Entity
@Table(name = "offer_reservation", schema = "unipointmain")
public class OfferReservation implements java.io.Serializable {

	private long reservationId;
	private Offer offer;
	private UnipointCustomerProfile unipointCustomerProfile;
	private String dateTime;
	private Float amountPaid;

	public OfferReservation() {
	}

	public OfferReservation(long reservationId) {
		this.reservationId = reservationId;
	}

	public OfferReservation(long reservationId, Offer offer, UnipointCustomerProfile unipointCustomerProfile,
			String dateTime, Float amountPaid) {
		this.reservationId = reservationId;
		this.offer = offer;
		this.unipointCustomerProfile = unipointCustomerProfile;
		this.dateTime = dateTime;
		this.amountPaid = amountPaid;
	}

	@Id

	@Column(name = "reservationID", nullable = false)
	public long getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offerID")
	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unipointCustomerID")
	public UnipointCustomerProfile getUnipointCustomerProfile() {
		return this.unipointCustomerProfile;
	}

	public void setUnipointCustomerProfile(UnipointCustomerProfile unipointCustomerProfile) {
		this.unipointCustomerProfile = unipointCustomerProfile;
	}

	@Column(name = "dateTime")
	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "amountPaid", precision = 8, scale = 8)
	public Float getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(Float amountPaid) {
		this.amountPaid = amountPaid;
	}

}