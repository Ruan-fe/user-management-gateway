package com.usermanagementgateway.api.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.usermanagementgateway.domain.dto.AccessResponseDTO;

public class AccessResponseModel {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public AccessResponseModel(AccessResponseDTO dto) {
        this.accessToken = dto.getAccessToken();
        this.refreshToken = dto.getRefreshToken();
        this.tokenType = dto.getTokenType();
    }
}
