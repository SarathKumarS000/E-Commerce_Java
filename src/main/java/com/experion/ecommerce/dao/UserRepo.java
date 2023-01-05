package com.experion.ecommerce.dao;

import com.experion.ecommerce.entity.Products;
import com.experion.ecommerce.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
public interface UserRepo extends JpaRepository<Users,Long> {
    Page<Users> findByuser_id(@Param("user_id") String user_id, Pageable pageable);
}
