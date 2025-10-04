package com.ecommerce.techlabs.order.service;

import com.ecommerce.techlabs.order.model.Order;
import com.ecommerce.techlabs.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create Order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get All Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order By Id
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
