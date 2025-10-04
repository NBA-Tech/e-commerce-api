package com.ecommerce.techlabs.order.controller;

import com.ecommerce.techlabs.order.model.Order;
import com.ecommerce.techlabs.order.dto.OrderRequest;
import com.ecommerce.techlabs.order.model.Order;
import com.ecommerce.techlabs.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // GET: All Orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // GET: Order By Id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) return ResponseEntity.ok(order);
        else return ResponseEntity.notFound().build();
    }

    // POST: Create Order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = new Order(
                orderRequest.getCustomerName(),
                orderRequest.getProduct(),
                orderRequest.getQuantity(),
                orderRequest.getPrice()
        );
        Order savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
}
