package com.suresh.config;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtProvider {

    SecretKey key = Keys.hmacShaKeyFor(JWT_CONSTANT.SECKET_KEY.getBytes());
}
