package com.experion.ecommerce.dao;

import com.experion.ecommerce.entity.Products;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo {
    List<Products> getAllProducts(String type, String sort);

}
