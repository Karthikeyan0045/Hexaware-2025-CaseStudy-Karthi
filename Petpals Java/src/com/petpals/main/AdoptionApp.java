package com.petpals.main;

import com.petpals.dao.*;

import java.util.Scanner;

public class AdoptionApp {
    public static void main(String[] args) {
        AdoptionEventDAO dao = new AdoptionEventDAOImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Upcoming Events:");
        dao.listEvents();

        System.out.print("Enter your name to register: ");
        String name = sc.nextLine();

        System.out.print("Are you a Shelter or Adopter? ");
        String type = sc.nextLine();

        System.out.print("Enter Event ID to register for: ");
        int eventId = sc.nextInt();

        dao.registerParticipant(name, type, eventId);
    }
}
