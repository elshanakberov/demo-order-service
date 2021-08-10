package com.example.demoorderservice.domain;

public enum DiscountType {

    ONE_FOR_ONE(new PercentageDiscount(0.0f)),
    THREE_FOR_TWO(new PercentageDiscount(0.66f));

    private final Discount discount;

    public Discount getDiscount() {
        return discount;
    }

     DiscountType(Discount discount) {
        this.discount = discount;
    }

}
