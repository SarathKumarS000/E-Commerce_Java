package com.experion.ecommerce.dao;

import com.experion.ecommerce.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
public interface ProductRepo extends JpaRepository<Products,String>{
}