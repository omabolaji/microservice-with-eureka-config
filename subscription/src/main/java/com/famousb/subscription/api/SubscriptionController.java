package com.famousb.subscription.api;

import com.famousb.subscription.domain.request.SubscriptionDto;
import com.famousb.subscription.domain.response.SubscriptionView;
import com.famousb.subscription.domain.utility.Utility;
import com.famousb.subscription.service.SubscriptionService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@RestController
@RequestMapping(path = "/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createSubscription(@RequestBody @Valid SubscriptionDto dto){
        try {
            SubscriptionView subscriptionView = subscriptionService.create(dto);
             return Utility.successResponse(subscriptionView,"Subscription created!", HttpStatus.CREATED,null);
        }catch (Exception ex){
            return Utility.successResponse(null, ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity<Object> getAllSubscription(){
        try {
            List<SubscriptionView> subscriptionViews = subscriptionService.getAllSubscription();
            return Utility.successResponse(subscriptionViews,"Subscription found!", HttpStatus.OK,null);
        }catch (Exception ex){
            return Utility.errorResponse(null, ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }
}
