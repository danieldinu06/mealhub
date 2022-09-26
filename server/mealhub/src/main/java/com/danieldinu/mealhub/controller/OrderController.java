package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/private/checkout")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void addOrder(@Valid @RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping
    @ResponseBody
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(path = "/{order_id}")
    @ResponseBody
    public ResponseEntity<Order> getOrder(@PathVariable(value = "order_id") Long id) {
        Optional<Order> order = orderService.getOrder(id);

        if (order.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }
}
