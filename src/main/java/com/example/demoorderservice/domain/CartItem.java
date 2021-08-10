package com.example.demoorderservice.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CartItem {

    private final Product product;

    private Integer quantity;

    public CartItem(Product product) {
        this(product, 1);
    }

    public Float getLineItemTotalBeforeDiscount() {
        switch(product.getProductType()) {
            case APPLE:
                return product.getPrice();
            default :
                return this.product.getPrice();
        }
    }

    public Integer addOne() {
        return quantity = quantity + 1;
    }

    public Integer reduceOne() {
        return quantity = quantity - 1;
    }



}
