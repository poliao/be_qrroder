package com.example.newweb.service;

import com.example.newweb.entity.OrderDetail;
import com.example.newweb.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrders() {
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> getOrderById(Long orderId) {
        return orderDetailRepository.findById(orderId);
    }

    public OrderDetail createOrder(OrderDetail orderDetail) {
        orderDetail.setStatus("RECEIVED");  // Default status when order is created
        return orderDetailRepository.save(orderDetail);
    }

    public OrderDetail updateOrderStatus(Long orderId, String status) {
        Optional<OrderDetail> orderOptional = orderDetailRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            OrderDetail orderDetail = orderOptional.get();
            orderDetail.setStatus(status);
            return orderDetailRepository.save(orderDetail);
        }
        return null;  // Or handle not found case appropriately
    }

    public void deleteOrder(Long orderId) {
        orderDetailRepository.deleteById(orderId);
    }
}
