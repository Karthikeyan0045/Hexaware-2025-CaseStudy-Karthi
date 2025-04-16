package com.petpals.dao;

import com.petpals.entity.Pet;
import com.petpals.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {
    public List<Pet> getAvailablePets() {
        List<Pet> pets = new ArrayList<>();
        try (Connection con = DBConnUtil.getConnection()) {
            String sql = "SELECT * FROM Pets WHERE AvailableForAdoption = 1";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("Age");
                String breed = rs.getString("Breed");
                pets.add(new Pet(name, age, breed));
            }
        } catch (Exception e) {
            System.out.println("Error fetching available pets: " + e.getMessage());
        }
        return pets;
    }
}
