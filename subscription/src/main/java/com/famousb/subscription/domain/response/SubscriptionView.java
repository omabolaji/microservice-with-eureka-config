package com.famousb.subscription.domain.response;

import com.famousb.subscription.domain.constant.SubscriptionType;
import com.famousb.subscription.model.Customer;
import com.famousb.subscription.model.Payment;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SubscriptionView {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String name;
    private String description;
    private LocalDate expiryDate;
    private SubscriptionType type;
    private Customer user;
    private Payment payment;
}
