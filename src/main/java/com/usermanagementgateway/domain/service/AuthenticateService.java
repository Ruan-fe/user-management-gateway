package com.usermanagementgateway.domain.service;

import com.usermanagementgateway.api.rest.repository.AuthenticationKCRepository;
import com.usermanagementgateway.api.rest.request.UserAuthenticateRequestModel;
import com.usermanagementgateway.api.rest.response.AccessResponseModel;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

    AuthenticationKCRepository repository;

    public AuthenticateService(AuthenticationKCRepository repository) {
        this.repository = repository;
    }

    public AccessResponseModel authenticate(UserAuthenticateRequestModel requestModel) throws Exception {
        return new AccessResponseModel(repository.get(requestModel));
    }
}
