package com.danieldinu.mealhub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "meals")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            columnDefinition = "TEXT"
    )
    @NonNull
    private String name;

    @Column(
            columnDefinition = "TEXT"
    )
//    @NonNull
    private String image;

    @Column(
            columnDefinition = "TEXT"
    )
    private String ingredients;

    private Double price;

    private Double discount;

    @ManyToMany(mappedBy = "meals")
    @JsonIgnore
    private Set<Restaurant> restaurants = new HashSet<>();

    @ManyToMany(mappedBy = "meals")
    @JsonIgnore
    private Set<Order> order = new HashSet<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}
