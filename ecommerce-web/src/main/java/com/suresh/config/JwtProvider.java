package com.suresh.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JwtProvider {

    SecretKey key = Keys.hmacShaKeyFor(JWT_CONSTANT.SECKET_KEY.getBytes());
        public String generateToken(Authentication auth) {
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            String role = popularAuthorities(authorities);
            return Jwts.builder()
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 86400000))
                    .claim("email", auth.getName())
                    .claim("authorities", role)
                    .signWith(key)
                    .compact();

        }
        public String getEmailFromJwtToken(String jwt){
            jwt =jwt.substring(7);
            SecretKey key = Keys.hmacShaKeyFor(JWT_CONSTANT.SECKET_KEY.getBytes());
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

            String email =String.valueOf(claims.get("email"));
            return email;
        }

    private String popularAuthorities(Collection<? extends GrantedAuthority> authorities) {
           Set<String> auth = new HashSet<>();
           for(GrantedAuthority authority : authorities){
               auth.add(authority.getAuthority());
           }

            return String.join("",auth);

    }
}
