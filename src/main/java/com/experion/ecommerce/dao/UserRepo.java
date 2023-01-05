package com.experion.ecommerce.dao;

import com.experion.ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "users",path="users")
public interface UserRepo extends JpaRepository<Users,String> {
}
