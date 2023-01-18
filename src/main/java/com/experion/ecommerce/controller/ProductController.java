package com.experion.ecommerce.controller;

import com.experion.ecommerce.dto.ProductPost;
import com.experion.ecommerce.entity.Products;
import com.experion.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Products> getProducts(@RequestParam(required = false) String type, @RequestParam(required = false) String sort){
        return productService.getAllProducts(type, sort);
    }
    @PostMapping("/add")
    public ProductPost addProduct(@RequestBody ProductPost request){
        return productService.addProduct(request);
    }
}