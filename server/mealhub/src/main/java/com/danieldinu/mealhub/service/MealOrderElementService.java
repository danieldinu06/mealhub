package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.MealOrderElement;
import com.danieldinu.mealhub.repository.MealOrderElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealOrderElementService {
    private final MealOrderElementRepository mealOrderElementRepository;

    @Autowired
    public MealOrderElementService(MealOrderElementRepository mealOrderElementRepository) {
        this.mealOrderElementRepository = mealOrderElementRepository;
    }

    public void addDrink(MealOrderElement mealOrderElement) {
        mealOrderElementRepository.save(mealOrderElement);
    }

    public void removeDrink(MealOrderElement mealOrderElement) {
        mealOrderElementRepository.delete(mealOrderElement);
    }
}
