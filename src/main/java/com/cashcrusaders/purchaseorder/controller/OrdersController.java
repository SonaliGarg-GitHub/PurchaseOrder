package com.cashcrusaders.purchaseorder.controller;

import com.cashcrusaders.purchaseorder.entitty.Orders;
import com.cashcrusaders.purchaseorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrdersController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Orders> showAllOrders(){
        return orderService.findAll();
    }

    @GetMapping("/order/{orderId}")
    public Orders showOrder(@PathVariable (value = "orderId") Integer orderId){
        return orderService.findOrder(orderId);
    }

    @PutMapping("/placeOrder")
    public Orders placeOrderFor(@RequestBody Map<String,Integer> root) {
        return orderService.placeOrder(root);
    }

}