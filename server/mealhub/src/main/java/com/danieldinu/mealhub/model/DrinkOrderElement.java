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
public class DrinkOrderElement extends OrderElement{
    @OneToOne
    @NonNull
    private Drink drink;

    public static void addDrink(Drink drink, List<DrinkOrderElement> orderElements) {
        boolean hasElement = false;

        for (DrinkOrderElement orderElement : orderElements) {
            if (orderElement.getDrink().equals(drink)) {
                orderElement.setQuantity(orderElement.getQuantity() + 1);
                hasElement = true;
            }
        }

        if (!hasElement) {
            orderElements.add(DrinkOrderElement.builder().drink(drink).quantity(1).build());
        }
    }
}
