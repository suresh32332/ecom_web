package com.suresh.service;

import com.suresh.response.SignupRequest;

public interface AuthService {
    String createUser(SignupRequest request);
}
