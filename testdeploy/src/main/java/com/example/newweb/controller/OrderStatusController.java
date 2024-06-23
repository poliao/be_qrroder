package com.example.newweb.controller;

import com.example.newweb.entity.OrderDetail;
import com.example.newweb.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderStatusController {

    @Autowired
    private OrderDetailService orderDetailService;

    @MessageMapping("/order-status")
    @SendTo("/topic/status")
    public OrderDetail updateOrderStatus(OrderDetail orderDetail) {
        return orderDetailService.updateOrderStatus(orderDetail.getOrderId(), orderDetail.getStatus());
    }
}
