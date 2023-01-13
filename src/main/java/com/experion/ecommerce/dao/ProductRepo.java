package com.experion.ecommerce.dao;

import com.experion.ecommerce.entity.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "products",path="products")
public interface ProductRepo extends JpaRepository<Products, Long> {
    List<Products> findByproductType(String type);
    List<Products> getProductsByPrice(Sort sort);
}
