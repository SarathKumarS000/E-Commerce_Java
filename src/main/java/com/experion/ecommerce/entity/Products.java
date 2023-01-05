package com.experion.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private String product_id;

    @Column(name="product_name")
    private String product_name;

    @Column(name="product_type")
    private String product_type;

    @Column(name="product_price")
    private Double product_price;
}
