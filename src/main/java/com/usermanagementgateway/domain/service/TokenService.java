package com.usermanagementgateway.domain.service;

import com.usermanagementgateway.api.rest.repository.TokenRepository;
import com.usermanagementgateway.api.rest.request.UserAuthenticateRequestModel;
import com.usermanagementgateway.api.rest.response.TokenResponseModel;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    TokenRepository repository;

    public TokenService(TokenRepository repository) {
        this.repository = repository;
    }

    public TokenResponseModel get(UserAuthenticateRequestModel requestModel) throws Exception {
        return new TokenResponseModel(repository.get(requestModel));
    }
}
