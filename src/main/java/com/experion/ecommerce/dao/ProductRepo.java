package com.experion.ecommerce.dao;

import com.experion.ecommerce.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
public interface ProductRepo extends JpaRepository<Products,Long> {
    Page<Products> findByproduct_id(@Param("product_id") String product_id, Pageable pageable);
}
