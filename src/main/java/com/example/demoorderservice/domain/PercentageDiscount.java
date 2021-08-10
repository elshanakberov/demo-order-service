package com.example.demoorderservice.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PercentageDiscount implements Discount{

    private float discountPercent ;

    public PercentageDiscount(float discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public float applyDiscount(CartItem lineItem) {
        return lineItem.getLineItemTotalBeforeDiscount() - (lineItem.getLineItemTotalBeforeDiscount() * ( discountPercent));
    }

}
