package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.DrinkOrderElement;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.MealOrderElement;
import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final DrinkOrderElementService drinkOrderElementService;
    private final MealOrderElementService mealOrderElementService;

    @Autowired
    public OrderService(OrderRepository orderRepository, DrinkOrderElementService drinkOrderElementService, MealOrderElementService mealOrderElementService) {
        this.orderRepository = orderRepository;
        this.drinkOrderElementService = drinkOrderElementService;
        this.mealOrderElementService = mealOrderElementService;
    }

    public void addMealToOrder(Long id, Meal meal) {
        if(orderRepository.findById(id).isEmpty()) { return; }
        Order order = orderRepository.findById(id).get();

        order.addMeal(meal);
        order.setPrice(calculateOrderPrice(order));

        MealOrderElement mealOrderElement = order.getMeal(meal);
        mealOrderElementService.addMeal(mealOrderElement);

        orderRepository.save(order);
    }

    public void addDrinkToOrder(Long id, Drink drink) {
        if(orderRepository.findById(id).isEmpty()) { return; }
        Order order = orderRepository.findById(id).get();

        order.addDrink(drink);
        order.setPrice(calculateOrderPrice(order));

        DrinkOrderElement drinkOrderElement = order.getDrink(drink);
        drinkOrderElementService.addDrink(drinkOrderElement);

        orderRepository.save(order);
    }

    public void removeMealFromOrder(Long id, Meal meal) {
        if(orderRepository.findById(id).isEmpty()) { return; }
        Order order = orderRepository.findById(id).get();

        MealOrderElement mealOrderElement = order.getMeal(meal);

        if(mealOrderElement.getQuantity() == 1) {
            order.removeMeal(meal);
            mealOrderElementService.removeMeal(mealOrderElement);
        } else {
            order.decreaseNumberOfMeals(meal);
            mealOrderElementService.addMeal(mealOrderElement);
        }

        order.setPrice(calculateOrderPrice(order));

        orderRepository.save(order);
    }

    public void removeDrinkFromOrder(Long id, Drink drink) {
        if(orderRepository.findById(id).isEmpty()) { return; }
        Order order = orderRepository.findById(id).get();

        DrinkOrderElement drinkOrderElement = order.getDrink(drink);

        if(drinkOrderElement.getQuantity() == 1) {
            order.removeDrink(drink);
            drinkOrderElementService.removeDrink(drinkOrderElement);
        } else {
            order.decreaseNumberOfDrinks(drink);
            drinkOrderElementService.addDrink(drinkOrderElement);
        }

        order.setPrice(calculateOrderPrice(order));

        orderRepository.save(order);
    }

    public void addOrder(Order order) {
        order.setPrice(calculateOrderPrice(order));
        orderRepository.save(order);
    }

    public Order getOrder(Long id) {
        if(orderRepository.findById(id).isEmpty()) { return null; }
        Order order = orderRepository.findById(id).get();

        order.setPrice(calculateOrderPrice(order));
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private Double calculateOrderPrice(Order order) {
        List<MealOrderElement> mealOrderElements = order.getMeals();
        List<DrinkOrderElement> drinkOrderElements = order.getDrinks();

        double price = 0.0;

        if (!mealOrderElements.isEmpty()) {
            for (MealOrderElement mealOrderElement : mealOrderElements) {
                price += (mealOrderElement.getMeal().getPrice() * mealOrderElement.getQuantity());
            }
        }

        if (!drinkOrderElements.isEmpty()) {
            for (DrinkOrderElement drinkOrderElement : drinkOrderElements) {
                price += (drinkOrderElement.getDrink().getPrice() * drinkOrderElement.getQuantity());
            }
        }

        return price;
    }
}