package com.example.demoorderservice.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Offer {

    private final Product product;
    private final DiscountType discountType;
    private final int quantity;

}
