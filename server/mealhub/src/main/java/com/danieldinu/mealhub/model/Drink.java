package com.danieldinu.mealhub.model;

import com.danieldinu.mealhub.model.utils.DrinkType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Table(name = "drinks")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Drink {
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
    private String name;

    @Column(
            columnDefinition = "TEXT"
    )
    @NonNull
    private String image;

    @NonNull
    private Double price;

    private Double discount;

    @NonNull
    private DrinkType type;

    @ManyToMany(mappedBy = "drinks")
    @JsonIgnore
    @Builder.Default
    private Set<Restaurant> restaurants = new HashSet<>();

    @ManyToMany(mappedBy = "drinks")
    @JsonIgnore
    @Builder.Default
    private Set<Order> order = new HashSet<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}