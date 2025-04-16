package com.petpals.main;

import com.petpals.dao.*;
import com.petpals.entity.*;

import java.util.List;

public class PetListingApp {
    public static void main(String[] args) {
        PetDAO petDAO = new PetDAOImpl();
        List<Pet> pets = petDAO.getAvailablePets();

        if (pets.isEmpty()) {
            System.out.println("No pets available right now.");
        } else {
            System.out.println("Available Pets:");
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }
    }
}
