package com.danieldinu.mealhub.model;

import com.danieldinu.mealhub.model.utils.MealType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "meals")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
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
    @NonNull
    private String image;

    @Column(
            columnDefinition = "TEXT"
    )
    @NonNull
    private String ingredients;

    @NonNull
    private Double price;

    private Double discount;

    @NonNull
    private MealType type;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "meal")
    private List<MealOrderElement> mealOrderElement;

    @ManyToMany(mappedBy = "meals")
    @JsonIgnore
    @Builder.Default
    private Set<Restaurant> restaurants = new HashSet<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}