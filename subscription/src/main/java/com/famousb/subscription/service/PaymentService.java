package com.famousb.subscription.service;

import com.famousb.subscription.domain.response.GeneralResponse;
import com.famousb.subscription.model.Customer;
import com.famousb.subscription.model.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service @RequiredArgsConstructor @Slf4j
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.api.base.url}")
    private String baseUrl;

    public Payment getPaymentById(String paymentId) throws Exception {
        try{
            String url = "http://PAYMENT-SERVICE" + "/payment/"+paymentId;

            HttpEntity<String> httpEntity = new HttpEntity<>(getHeaders());

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);
            log.info("status code: {}", response.getStatusCode());
            if(response.getStatusCode() == HttpStatus.BAD_REQUEST){
                throw new Exception("Payment not found");
            }
            log.info("payment data: {}", response.getBody());
            ObjectMapper mapper = new ObjectMapper();
            GeneralResponse resp = mapper.readValue(response.getBody(),GeneralResponse.class);
            Payment payment = mapper.convertValue(resp.getData(), Payment.class);
            return payment;
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
