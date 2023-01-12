package com.experion.ecommerce.service;

import com.experion.ecommerce.dao.UserRepo;
import com.experion.ecommerce.dto.TokenJsonResponse;
import com.experion.ecommerce.dto.UserPost;
import com.experion.ecommerce.entity.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public ResponseEntity parseToken(UserPost userPost) throws JsonProcessingException {
        String token = userPost.getUsertoken();
        String[] details = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(details[0]));
        String payload = new String(decoder.decode(details[1]));
        System.out.println(payload);
        TokenJsonResponse tokenJsonResponse = new ObjectMapper().readValue(payload, TokenJsonResponse.class);

        Users user = new Users();
         user.setUsername(tokenJsonResponse.getName());
         user.setProfileurl(tokenJsonResponse.getPicture());
         user.setEmail(tokenJsonResponse.getEmail());
         userRepo.save(user);

        return new ResponseEntity(tokenJsonResponse, HttpStatus.OK);
    }
}

