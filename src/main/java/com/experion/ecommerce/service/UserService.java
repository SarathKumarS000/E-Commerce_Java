package com.experion.ecommerce.service;

import com.experion.ecommerce.dto.UserPost;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity parseToken(UserPost userPost) throws JsonProcessingException;
}
