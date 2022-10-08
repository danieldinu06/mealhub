package com.danieldinu.mealhub.model.baseModel;

import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.model.utils.DrinkType;
import com.danieldinu.mealhub.model.utils.MealType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    private String ingredients;

    @Column(
            columnDefinition = "TEXT"
    )
    private String image;

    private Double price;

    private Double discount;

    private MealType mealType;

    private DrinkType drinkType;

    @ManyToMany(mappedBy = "drinks")
    @JsonIgnore
    private Set<Restaurant> restaurants;

    @ManyToMany(mappedBy = "drinks")
    @JsonIgnore
    private Set<Order> order = new HashSet<>();

    public void addRestaurant(Restaurant restaurant) {
        if (restaurants == null) {
            restaurants = new HashSet<>();
        }
        restaurants.add(restaurant);
    }

}
