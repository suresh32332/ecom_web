package com.suresh.HomeController;

import com.suresh.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ApiResponse homecontroller(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("well come to ecommerce website");
        return apiResponse;
    }
}
