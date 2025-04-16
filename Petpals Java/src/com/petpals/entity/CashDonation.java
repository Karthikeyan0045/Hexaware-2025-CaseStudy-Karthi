package com.petpals.entity;

import java.time.LocalDateTime;

public class CashDonation extends Donation {
    private LocalDateTime donationDate;

    public CashDonation(String donorName, double amount, LocalDateTime donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    public LocalDateTime getDonationDate() { return donationDate; }

    @Override
    public void recordDonation() {
        System.out.println("Cash Donation: " + donorName + " - ₹" + amount + " on " + donationDate);
    }
}
