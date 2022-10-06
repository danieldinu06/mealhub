package com.danieldinu.mealhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double price;

    private Double discount;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_drink",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id")
    )
    private List<DrinkOrderElement> drinks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "order_meal",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public void addDrink(Drink drink) {
        boolean hasDrink = false;

        for (DrinkOrderElement drinkOrderElement : drinks) {
            if (drinkOrderElement.getDrink().equals(drink)) {
                drinkOrderElement.setQuantity(drinkOrderElement.getQuantity() + 1);
                hasDrink = true;
            }
        }

        if (!hasDrink) {
            drinks.add(new DrinkOrderElement(drink, 1));
        }
    }

    public DrinkOrderElement getDrink(Drink drink) {
        for (DrinkOrderElement drinkOrderElement : drinks) {
            if (drinkOrderElement.getDrink().equals(drink)) {
                return drinkOrderElement;
            }
        }
        return null;
    }

    public void removeDrink(Drink drink) {
        for (DrinkOrderElement drinkOrderElement : drinks) {
            if (drinkOrderElement.getDrink().equals(drink)) {
                if (drinkOrderElement.getQuantity() > 1) {
                    drinkOrderElement.setQuantity(drinkOrderElement.getQuantity() - 1);
                } else {
                    drinks.remove(drinkOrderElement);
                }
            }
        }
    }
}
