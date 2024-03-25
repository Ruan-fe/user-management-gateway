package com.usermanagementgateway.api.rest.endpoints;

import com.usermanagementgateway.api.rest.request.UserAuthenticateRequestModel;
import com.usermanagementgateway.api.rest.response.TokenResponseModel;
import com.usermanagementgateway.domain.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    public static final String USERS_AUTHENTICATE_RESOURCE_PATH = "/api/users/authenticate";

    TokenService tokenService;

    public UserEndpoint(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping(USERS_AUTHENTICATE_RESOURCE_PATH)
    public ResponseEntity<TokenResponseModel> authenticate(@RequestBody UserAuthenticateRequestModel requestModel) throws Exception {
        TokenResponseModel tokenResponseModel = tokenService.get(requestModel);
        return ResponseEntity.ok(tokenResponseModel);
    }

}
