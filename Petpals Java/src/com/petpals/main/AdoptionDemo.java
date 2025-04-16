package com.petpals.main;

import com.petpals.entity.*;
import com.petpals.exception.AdoptionException;

public class AdoptionDemo {
    public static void main(String[] args) {
        try {
            Pet p = new Pet("Tommy", 0, "Labrador");
            boolean isAvailable = false;

            if (!isAvailable) {
                throw new AdoptionException("This pet is not available for adoption.");
            }

            System.out.println("Adoption successful!");
        } catch (AdoptionException e) {
            System.out.println("Adoption failed: " + e.getMessage());
        }
    }
}
