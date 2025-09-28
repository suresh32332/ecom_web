package com.suresh.service.Impl;

import com.suresh.response.SignupRequest;
import com.suresh.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public String createUser(SignupRequest request) {
        return "";
    }
}
