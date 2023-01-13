package com.experion.ecommerce.service;

import com.experion.ecommerce.dao.ProductRepo;
import com.experion.ecommerce.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public List<Products> findProductwithAscSorting(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    @Override
    public List<Products> findProductwithDescSorting(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }
}
