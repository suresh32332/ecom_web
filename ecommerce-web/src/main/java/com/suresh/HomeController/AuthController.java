package com.suresh.HomeController;

import com.suresh.domain.USER_ROLE;
import com.suresh.model.User;
import com.suresh.repository.UserRepository;
import com.suresh.response.AuthResponse;
import com.suresh.response.SignupRequest;
import com.suresh.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req){
        String jwt = authService.createUser(req);
        AuthResponse response = new AuthResponse();
        response.setJwt(jwt);
        response.setMessage("Register Success");
        response.setRole(USER_ROLE.ROLE_CUSTOMER);
        return ResponseEntity.ok(response);
    }
}
