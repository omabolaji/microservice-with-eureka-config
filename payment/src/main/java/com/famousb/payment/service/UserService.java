package com.famousb.payment.service;

import com.famousb.payment.domain.response.GeneralResponse;
import com.famousb.payment.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor @Slf4j
public class UserService {


    private final RestTemplate restTemplate;

    @Value("${spring.api.base.url}")
    private String baseUrl;

    public Customer getUserDetail(String email) throws Exception {
        try{
          String url = "http://USER-SERVICE" + "/user/email/"+email;

          HttpEntity<String> httpEntity = new HttpEntity<>(getHeaders());

          ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);
            log.info("status code: {}", response.getStatusCode());
          if(response.getStatusCode() == HttpStatus.BAD_REQUEST){
            throw new Exception("User profile not found");
          }
          log.info("customer data: {}", response.getBody());
          ObjectMapper mapper = new ObjectMapper();
          GeneralResponse resp = mapper.readValue(response.getBody(),GeneralResponse.class);
          Customer customer = mapper.convertValue(resp.getData(),Customer.class);
          return customer;
        }catch (Exception ex){
           ex.printStackTrace();
           throw new Exception("An error occurred");
        }
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
