package com.danieldinu.mealhub.repository;

import com.danieldinu.mealhub.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query("select m from Meal m inner join Restaurant rm on rm.id = :id")
    Set<Meal> findByRestaurantId(Long id);
}
