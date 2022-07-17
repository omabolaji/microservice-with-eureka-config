package com.famousb.subscription.domain.request;

import com.famousb.subscription.domain.constant.SubscriptionType;
import com.famousb.subscription.model.Customer;
import com.famousb.subscription.model.Payment;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class SubscriptionDto {
    @NotNull
    private SubscriptionType type;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Payment payment;
    private Customer user;
    private LocalDate expiryDate;

}
