package com.danieldinu.mealhub.model;

import com.danieldinu.mealhub.model.baseModel.OrderElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class MealOrderElement extends OrderElement{
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Meal meal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Order order;
}
