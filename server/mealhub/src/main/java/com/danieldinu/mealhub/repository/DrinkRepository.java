package com.danieldinu.mealhub.repository;

import com.danieldinu.mealhub.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    @Query("select d from Drink d inner join d.restaurants r where r.id = :id")
    Set<Drink> findByRestaurantId(Long id);
}
