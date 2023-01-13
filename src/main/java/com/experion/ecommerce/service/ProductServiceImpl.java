package com.experion.ecommerce.service;

import com.experion.ecommerce.dao.ProductRepo;
import com.experion.ecommerce.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Products> getAllProducts(String type){
        if(type == null)
            return productRepo.findAll();
        else
        {
            return productRepo.findByproductType(type);
        }
    }

    @Override
    public List<Products> getProductsByPrice() {
        var sort = Sort.by(Sort.Direction.ASC, "productPrice");
        return productRepo.getProductsByPrice(sort);
    }
}
