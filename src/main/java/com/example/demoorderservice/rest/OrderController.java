package com.example.demoorderservice.rest;

import com.example.demoorderservice.domain.Basket;
import com.example.demoorderservice.domain.CartItem;
import com.example.demoorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> createOrder(){
        orderService.createOrder();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CartItem>> retrieve(@RequestParam("orderId") Integer orderId){
        var orders = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}
