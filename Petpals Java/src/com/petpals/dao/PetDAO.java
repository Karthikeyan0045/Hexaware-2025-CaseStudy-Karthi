package com.petpals.dao;

import com.petpals.entity.Pet;
import java.util.List;

public interface PetDAO {
    List<Pet> getAvailablePets();
}
