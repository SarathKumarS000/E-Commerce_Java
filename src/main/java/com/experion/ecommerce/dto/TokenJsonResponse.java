package com.experion.ecommerce.dto;

import lombok.Data;

@Data
public class TokenJsonResponse {
    private String iss;
    private String nbf;
    private String aud;
    private String sub;
    private String email;
    private String email_verified;
    private String azp;
    private String name;
    private String picture;
    private String given_name;
    private String family_name;
    private String iat;
    private String exp;
    private String jti;
    private String hd;
    private String at_hash;
    private String locale;
}
