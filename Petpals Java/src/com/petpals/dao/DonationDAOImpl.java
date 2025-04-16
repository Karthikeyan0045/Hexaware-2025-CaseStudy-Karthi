package com.petpals.dao;

import com.petpals.entity.CashDonation;
import com.petpals.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DonationDAOImpl implements DonationDAO {
    public void addCashDonation(CashDonation donation) {
        try (Connection con = DBConnUtil.getConnection()) {
            String sql = "INSERT INTO Donations (Donorname, DonationType, DonationAmount, DonationItem, DonationDate) VALUES (?, 'Cash', ?, NULL, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, donation.getDonorName());
            ps.setDouble(2, donation.getAmount());
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(donation.getDonationDate()));
            ps.executeUpdate();

            System.out.println("Donation recorded successfully.");
        } catch (Exception e) {
            System.out.println("Error recording donation: " + e.getMessage());
        }
    }
}
