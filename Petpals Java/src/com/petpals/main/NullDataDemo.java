package com.petpals.main;

import com.petpals.entity.*;
import com.petpals.exception.NullPetDataException;

public class NullDataDemo {
    public static void main(String[] args) {
        try {
            Pet p1 = new Pet(null, 3, null);
            if (p1.getName() == null || p1.getBreed() == null) {
                throw new NullPetDataException("Pet data is missing (name or breed is null).");
            }
            System.out.println(p1);
        } catch (NullPetDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
