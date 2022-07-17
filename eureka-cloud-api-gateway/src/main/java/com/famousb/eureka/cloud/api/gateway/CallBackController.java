package com.famousb.eureka.cloud.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallBackController {

    @GetMapping("/callBackUser")
    public String callBackUserService(){
        return "User service is down, please try again later";
    }

    @GetMapping("/callBackPayment")
    public String callBackUserPayment(){
        return "Payment service is down, please try again later";
    }

    @GetMapping("/callBackSubscription")
    public String callBackUserSubscription(){
        return "Subscription service is down, please try again later";
    }

}
