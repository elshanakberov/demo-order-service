package com.example.demoorderservice.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Product {

    private String productCode;

    private ProductType productType;

    private Float price;

}
