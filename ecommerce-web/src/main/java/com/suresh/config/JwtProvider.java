package com.suresh.config;

import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Collection;

public class JwtProvider {

    SecretKey key = Keys.hmacShaKeyFor(JWT_CONSTANT.SECKET_KEY.getBytes());
        public String generateToken(Authorization auth){
            Collection<? extends GrantedAuthority> authorities =auth.getAuthorities();
            String role =popularAuthorities(authorities);

            return null;
        }

    private String popularAuthorities(Collection<? extends GrantedAuthority> authorities) {
    }
}
