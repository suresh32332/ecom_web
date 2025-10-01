package com.suresh.service.Impl;


import com.suresh.config.JwtProvider;
import com.suresh.domain.USER_ROLE;
import com.suresh.model.Card;
import com.suresh.model.User;
import com.suresh.repository.CardRopsitory;
import com.suresh.repository.UserRepository;
import com.suresh.response.SignupRequest;
import com.suresh.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CardRopsitory cardRopsitory;
    private final JwtProvider jwtProvider;

    @Override
    public String createUser(SignupRequest request) {
        User user=userRepository.findByEmail(request.getEmail());
         if(user == null){
             User createUser = new User();
             createUser.setEmail(request.getEmail());
             createUser.setFullName(request.getFullName());
             createUser.setRole(USER_ROLE.ROLE_CUSTOMER);
             createUser.setMobile("1234567890");
             createUser.setPassword(passwordEncoder.encode(request.getOtp()));
             user =userRepository.save(createUser);

             Card card = new Card();
             card.setUser(user);
             cardRopsitory.save(card);
         }
         List<GrantedAuthority> authority = new ArrayList<>();
         authority.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));

        Authentication authentication =new UsernamePasswordAuthenticationToken(request.getEmail(),null,authority);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);

    }
}
