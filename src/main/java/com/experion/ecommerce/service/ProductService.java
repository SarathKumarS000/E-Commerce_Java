package com.experion.ecommerce.service;

import com.experion.ecommerce.entity.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public interface ProductService {
    List<Products> getAllProducts(String type);
    List<Products> getProductsByPrice();
}
