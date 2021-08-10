package com.example.demoorderservice.domain;

public interface Discount {
    float applyDiscount(CartItem lineItem);
}
