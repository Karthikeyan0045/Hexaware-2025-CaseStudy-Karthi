package com.petpals.main;

import com.petpals.dao.*;
import com.petpals.entity.*;
import com.petpals.exception.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PetDAO petDAO = new PetDAOImpl();
        DonationDAO donationDAO = new DonationDAOImpl();
        AdoptionEventDAO eventDAO = new AdoptionEventDAOImpl();

        int choice;
        do {
            System.out.println("\n===== PETPALS MAIN MENU =====");
            System.out.println("1. View Available Pets");
            System.out.println("2. Make a Cash Donation");
            System.out.println("3. View Upcoming Adoption Events");
            System.out.println("4. Register for Adoption Event");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    List<Pet> pets = petDAO.getAvailablePets();
                    if (pets.isEmpty()) {
                        System.out.println("No pets available right now.");
                    } else {
                        System.out.println("Available Pets:");
                        for (Pet pet : pets) {
                            System.out.println(pet);
                        }
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Donor Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Donation Amount (₹): ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        if (amount < 10) {
                            throw new InsufficientFundsException("Minimum donation is ₹10.");
                        }

                        CashDonation donation = new CashDonation(name, amount, LocalDateTime.now());
                        donationDAO.addCashDonation(donation);

                    } catch (InsufficientFundsException e) {
                        System.out.println("❌ " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("❌ Donation failed: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Upcoming Events:");
                    eventDAO.listEvents();
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String pname = sc.nextLine();
                    System.out.print("Are you a Shelter or Adopter? ");
                    String ptype = sc.nextLine();
                    System.out.print("Enter Event ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine();

                    eventDAO.registerParticipant(pname, ptype, eid);
                    break;

                case 5:
                    System.out.println("👋 Thanks for using PetPals! Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 5);
    }
}
