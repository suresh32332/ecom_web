package com.suresh.service.Impl;

import com.suresh.domain.USER_ROLE;
import com.suresh.model.Seller;
import com.suresh.model.User;
import com.suresh.repository.SellerRepository;
import com.suresh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CustomUserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;
    private static final String SELLER_PREFIX="seller";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.startsWith(SELLER_PREFIX)){
            String actualUserName = username.substring(SELLER_PREFIX.length());
            Seller seller = sellerRepository.findByEmail(actualUserName);
            if( seller != null){
                return buildUserService(seller.getEmail(),seller.getPassword(),seller.getRole());
            }

        }else {
            User user =userRepository.findByEmail(username);
            if(user !=null){
                return buildUserService(user.getEmail(),user.getPassword(), user.getRole());
            }
        }
        throw new UsernameNotFoundException("User or Seller not found with email : " + username);
    }

    private UserDetails buildUserService(String email, String password, USER_ROLE role) {
         if(role ==null) role=USER_ROLE.ROLE_CUSTOMER;
         List<GrantedAuthority> list = new ArrayList<>();
         list.add(new SimpleGrantedAuthority("ROLE" + role));

         return new org.springframework.security.core.userdetails.User(
                 email, password,list
         );
    }
}
