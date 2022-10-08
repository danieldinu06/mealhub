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
public class Order{
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
    private List<MealOrderElement> meals = new ArrayList<>();

    public void addDrink(Drink drink) {
        DrinkOrderElement.addDrink(drink, drinks);
    }

    public void addMeal(Meal meal) {
        MealOrderElement.addMeal(meal, meals);
    }

    public DrinkOrderElement getDrink(Drink drink) {
        for (DrinkOrderElement drinkOrderElement : drinks) {
            if (drinkOrderElement.getDrink().equals(drink)) {
                return drinkOrderElement;
            }
        }
        return null;
    }

    public MealOrderElement getMeal(Meal meal) {
        for (MealOrderElement mealOrderElement : meals) {
            if (mealOrderElement.getMeal().equals(meal)) {
                return mealOrderElement;
            }
        }
        return null;
    }

    public void decreaseNumberOfDrinks(Drink drink) {
        for (DrinkOrderElement drinkOrderElement : drinks) {
            if (drinkOrderElement.getDrink().equals(drink)) {
                if (drinkOrderElement.getQuantity() > 1) {
                    drinkOrderElement.setQuantity(drinkOrderElement.getQuantity() - 1);
                }
            }
        }
    }

    public void decreaseNumberOfMeals(Meal meal) {
        for (MealOrderElement mealOrderElement : meals) {
            if (mealOrderElement.getMeal().equals(meal)) {
                if (mealOrderElement.getQuantity() > 1) {
                    mealOrderElement.setQuantity(mealOrderElement.getQuantity() - 1);
                }
            }
        }
    }

    public void removeDrink(Drink drink) {
        drinks.removeIf(drinkOrderElement -> drinkOrderElement.getDrink().equals(drink));
    }

    public void removeMeal(Meal meal) {
        meals.removeIf(mealOrderElement -> mealOrderElement.getMeal().equals(meal));
    }
}
