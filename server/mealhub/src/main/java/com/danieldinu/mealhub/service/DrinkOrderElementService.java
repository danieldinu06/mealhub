package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.DrinkOrderElement;
import com.danieldinu.mealhub.repository.DrinkOrderElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkOrderElementService {
    private final DrinkOrderElementRepository drinkOrderElementRepository;

    @Autowired
    public DrinkOrderElementService(DrinkOrderElementRepository drinkOrderElementRepository) {
        this.drinkOrderElementRepository = drinkOrderElementRepository;
    }

    public Optional<DrinkOrderElement> getDrink(Long id) {
        return drinkOrderElementRepository.findById(id);
    }

    public List<DrinkOrderElement> getAllDrinks() {
        return drinkOrderElementRepository.findAll();
    }

    public void addDrink(DrinkOrderElement drinkOrderElement) {
        drinkOrderElementRepository.save(drinkOrderElement);
    }

    public void removeDrink(DrinkOrderElement drinkOrderElement) {
        drinkOrderElementRepository.delete(drinkOrderElement);
    }
}
