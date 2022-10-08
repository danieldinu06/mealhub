package com.danieldinu.mealhub.model;

import com.danieldinu.mealhub.model.baseModel.OrderElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class MealOrderElement extends OrderElement{
    @OneToOne
    @NonNull
    private Meal meal;

    public static void addMeal(Meal meal, List<MealOrderElement> orderElements) {
        boolean hasElement = false;

        for (MealOrderElement orderElement : orderElements) {
            if (orderElement.getMeal().equals(meal)) {
                orderElement.setQuantity(orderElement.getQuantity() + 1);
                hasElement = true;
            }
        }

        if (!hasElement) {
            orderElements.add(MealOrderElement.builder().meal(meal).quantity(1).build());
        }
    }
}
