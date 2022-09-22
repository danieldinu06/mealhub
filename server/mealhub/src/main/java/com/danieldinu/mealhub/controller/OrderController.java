package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/private/checkout")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

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
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public ResponseEntity<Order> getOrder(@PathVariable(value = "order_id") Long id) {
        Optional<Order> order = orderService.getOrder(id);

        if (order.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }
}
