package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Optional<Order> getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        order.get().setPrice(calculateOrderPrice(order.get()));
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private Double calculateOrderPrice(Order order) {
        List<Meal> meals = order.getMeals();
        List<Drink> drinks = order.getDrinks();
        Double price = 0.0;

        if (!meals.isEmpty()) {
            for (Meal meal : meals) {
                price += meal.getPrice();
            }
        }

        if (!drinks.isEmpty()) {
            for (Drink drink : drinks) {
                price += drink.getPrice();
            }
        }

        return price;
    }
}
