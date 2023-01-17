package com.experion.ecommerce.dto;

import lombok.Data;

@Data
public class ProductPost {

    private Long productId;
    private String productName;
    private String productType;
    private Double productPrice;
    private String productImage;

}
