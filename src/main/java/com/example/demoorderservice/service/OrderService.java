package com.example.demoorderservice.service;

import com.example.demoorderservice.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private Map<Integer, List<CartItem>> orders = new HashMap<>();
    private Map<String, Offer> map = new HashMap<>();
    private DiscountStrategy discountStrategy = new DiscountStrategy();
    private Basket basket = new Basket(map,discountStrategy);


    public void createOrder() {

         Product apple = new Product("Apple", ProductType.APPLE,60.00f);
         Product orange = new Product("Orange", ProductType.ORANGE,25.00f);

        map.put("APPLE", new Offer(apple, DiscountType.ONE_FOR_ONE,2));

        CartItem apple_1 = new CartItem(apple);
        CartItem apple_2 = new CartItem(apple);
        CartItem apple_3 = new CartItem(apple);

        CartItem orange_1 = new CartItem(orange);
        CartItem orange_2 = new CartItem(orange);
        CartItem orange_3 = new CartItem(orange);


        basket.addCartItem(apple_1);
        basket.addCartItem(apple_2);
        basket.addCartItem(apple_3);

        basket.addCartItem(orange_1);
        basket.addCartItem(orange_2);
        basket.addCartItem(orange_3);

        orders.put(1,basket.getCartItemList());

    }

    public List<CartItem> getOrderById(Integer orderId) {
        return Collections.unmodifiableList(orders.get(orderId));
    }
}
