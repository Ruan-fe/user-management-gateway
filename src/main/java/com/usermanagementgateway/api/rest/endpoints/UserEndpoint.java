package com.usermanagementgateway.api.rest.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    @PostMapping("/api/users/authenticate")
    public void authenticate() {
        System.out.printf("Autenticado!");
    }
}
