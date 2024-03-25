package com.usermanagementgateway.api.rest.endpoints;

import com.usermanagementgateway.api.rest.request.UserAuthenticateRequestModel;
import com.usermanagementgateway.api.rest.response.AccessResponseModel;
import com.usermanagementgateway.domain.dto.AccessResponseDTO;
import com.usermanagementgateway.domain.service.AuthenticateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    public static final String USERS_AUTHENTICATE_RESOURCE_PATH = "/api/users/authenticate";

    AuthenticateService authenticateService;

    public UserEndpoint(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping(USERS_AUTHENTICATE_RESOURCE_PATH)
    public ResponseEntity<AccessResponseModel> authenticate(@RequestBody UserAuthenticateRequestModel requestModel) throws Exception {
        AccessResponseModel accessResponseModel = authenticateService.authenticate(requestModel);
        return ResponseEntity.ok(accessResponseModel);
    }

}
