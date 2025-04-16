package com.petpals.main;

import com.petpals.entity.*;
import com.petpals.exception.InvalidAgeException;

import java.util.Scanner;

public class InvalidAgeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter pet name: ");
            String name = sc.nextLine();

            System.out.print("Enter pet age: ");
            int age = sc.nextInt();
            sc.nextLine();

            if (age <= 0) {
                throw new InvalidAgeException("Age must be a positive integer.");
            }

            System.out.print("Enter pet breed: ");
            String breed = sc.nextLine();

            Pet pet = new Pet(name, age, breed);
            PetShelter shelter = new PetShelter();
            shelter.addPet(pet);

            System.out.println("Pet added to shelter.");
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
