package com.courier.entity;


import java.util.Date;

public class Payment {
    private long paymentId;
    private long courierId;
    private int locationId;
    private double amount;
    private Date paymentDate;

    public Payment() {}

    public Payment(long paymentId, long courierId, int locationId, double amount, Date paymentDate) {
        this.paymentId = paymentId;
        this.courierId = courierId;
        this.locationId = locationId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getCourierId() {
		return courierId;
	}

	public void setCourierId(long courierId) {
		this.courierId = courierId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", courierId=" + courierId + ", locationId=" + locationId
				+ ", amount=" + amount + ", paymentDate=" + paymentDate + "]";
	}

    // Getters, Setters, toString
}
