package com.example.newweb.controller;

import com.example.newweb.entity.OrderDetail;
import com.example.newweb.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public List<OrderDetail> getAllOrders() {
        return orderDetailService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Optional<OrderDetail> getOrderById(@PathVariable Long orderId) {
        return orderDetailService.getOrderById(orderId);
    }

    @PostMapping
    public OrderDetail createOrder(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.createOrder(orderDetail);
    }

    @PutMapping("/{orderId}/status")
    public OrderDetail updateOrderStatus(@PathVariable Long orderId, @RequestBody String status) {
        return orderDetailService.updateOrderStatus(orderId, status);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderDetailService.deleteOrder(orderId);
    }
}
