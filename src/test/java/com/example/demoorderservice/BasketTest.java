package com.example.demoorderservice;

import java.util.HashMap;
import java.util.Map;

import com.example.demoorderservice.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {
    private Basket basket = null;
    private DiscountStrategy discountStrategy = null;
    private Map<String, Offer> map = null;

    private Product apple = new Product("Apple", ProductType.APPLE,60.00f);
    private Product orange = new Product("Orange", ProductType.ORANGE,25.00f);


    @BeforeEach
    public void setup() {
        discountStrategy = new DiscountStrategy();
        map = new HashMap<>();
        basket = new Basket(map,discountStrategy);
    }

    @AfterEach
    public void cleanUp() {
        map.clear();
    }

    @Test
    public void testApply1For1Offer() {
        map.put("APPLE", new Offer(apple, DiscountType.ONE_FOR_ONE,2));

        CartItem apple_1 = new CartItem(apple);
        CartItem apple_2 = new CartItem(apple);
        CartItem apple_3 = new CartItem(apple);

        basket.addCartItem(apple_1);
        basket.addCartItem(apple_2);
        basket.addCartItem(apple_3);

        assertThat(basket.getTotalPriceAfterDiscount() == 120.0);

    }

    @Test
    public void testApply3For2Offer() {
        map.put("ORANGE", new Offer(orange,DiscountType.THREE_FOR_TWO,3));

        CartItem orange_1 = new CartItem(orange);
        CartItem orange_2 = new CartItem(orange);
        CartItem orange_3 = new CartItem(orange);

        basket.addCartItem(orange_1);
        basket.addCartItem(orange_2);
        basket.addCartItem(orange_3);

        assertThat(basket.getTotalPriceAfterDiscount() == 50.0);

    }

}
