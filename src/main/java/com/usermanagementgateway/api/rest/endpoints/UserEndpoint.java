package com.usermanagementgateway.api.rest.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    public static final String USERS_AUTHENTICATE_RESOURCE_PATH = "/api/users/authenticate";

    @PostMapping(USERS_AUTHENTICATE_RESOURCE_PATH)
    public void authenticate() {
        System.out.printf("Autenticado!");
    }

}
