package com.danieldinu.mealhub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "restaurants")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NonNull
    @NotNull(message = "Name is required!")
    private String name;

    @Column(
            columnDefinition = "TEXT"
    )
    @NonNull
    private String logo;

    @Column(
            columnDefinition = "TEXT"
    )
    @NonNull
    @NotNull(message = "Location is required!")
    private String location;

    private Double rating;

    @NonNull
    @NotNull
    private Double deliveryFee;

    private Time estimatedTime;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> order = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "restaurant_drink",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id")
    )
    private Set<Drink> drinks = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "restaurant_meal",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private Set<Meal> meals = new HashSet<>();

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }
    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addOrder(Order order) { this.order.add(order); }
}
