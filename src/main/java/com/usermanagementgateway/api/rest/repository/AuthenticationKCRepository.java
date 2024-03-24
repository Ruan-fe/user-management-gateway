package com.usermanagementgateway.api.rest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagementgateway.api.rest.request.UserAuthenticateRequestModel;
import com.usermanagementgateway.domain.dto.AccessResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Repository
public class AuthenticationKCRepository {

    @Value("${api.keycloak.client-id}")
    private String CLIENT_ID;
    @Value("${api.keycloak.grant-type}")
    private String GRANT_TYPE;
    @Value("${api.keycloak.authenticate.url}")
    private String URL;

    public AccessResponseDTO get(UserAuthenticateRequestModel requestModel) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<Object> response;

        try {
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("username", requestModel.getUsername());
            map.add("password", requestModel.getPassword());
            map.add("client_id", this.CLIENT_ID);
            map.add("grant_type", this.GRANT_TYPE);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            response = restTemplate.exchange(this.URL, HttpMethod.POST, request, Object.class);
        } catch (HttpClientErrorException e) {
            throw new Exception();
        } catch (Exception e) {
            throw new Exception();
        }
        HttpStatus responseCode = (HttpStatus) response.getStatusCode();
        if (Objects.equals(HttpStatus.OK, responseCode)) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.convertValue(response.getBody(), AccessResponseDTO.class);
        } else {
            throw new Exception();
        }
    }
}

