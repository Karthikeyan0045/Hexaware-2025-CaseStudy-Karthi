package com.petpals.main;

import com.petpals.entity.*;
import com.petpals.exception.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DonationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter donor name: ");
            String name = sc.nextLine();

            System.out.print("Enter donation amount: ");
            double amount = sc.nextDouble();

            if (amount < 10) {
                throw new InsufficientFundsException("Minimum donation is ₹10.");
            }

            CashDonation donation = new CashDonation(name, amount, LocalDateTime.now());
            donation.recordDonation();

        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
