package com.unipoint.merchant.model;
// Generated Oct 18, 2016 4:59:22 PM by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MerchantCustomerUnipointRewardsId generated by hbm2java
 */
@Embeddable
public class MerchantCustomerUnipointRewardsId implements java.io.Serializable {

	private long mechantCustomerId;
	private long pointsRewardsId;

	public MerchantCustomerUnipointRewardsId() {
	}

	public MerchantCustomerUnipointRewardsId(long mechantCustomerId, long pointsRewardsId) {
		this.mechantCustomerId = mechantCustomerId;
		this.pointsRewardsId = pointsRewardsId;
	}

	@Column(name = "mechant_customer_id", nullable = false)
	public long getMechantCustomerId() {
		return this.mechantCustomerId;
	}

	public void setMechantCustomerId(long mechantCustomerId) {
		this.mechantCustomerId = mechantCustomerId;
	}

	@Column(name = "points_rewards_id", nullable = false)
	public long getPointsRewardsId() {
		return this.pointsRewardsId;
	}

	public void setPointsRewardsId(long pointsRewardsId) {
		this.pointsRewardsId = pointsRewardsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MerchantCustomerUnipointRewardsId))
			return false;
		MerchantCustomerUnipointRewardsId castOther = (MerchantCustomerUnipointRewardsId) other;

		return (this.getMechantCustomerId() == castOther.getMechantCustomerId())
				&& (this.getPointsRewardsId() == castOther.getPointsRewardsId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getMechantCustomerId();
		result = 37 * result + (int) this.getPointsRewardsId();
		return result;
	}

}