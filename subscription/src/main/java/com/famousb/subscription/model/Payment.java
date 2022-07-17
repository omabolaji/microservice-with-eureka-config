package com.famousb.subscription.model;

import com.famousb.subscription.domain.constant.PaymentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
    @NotNull
    private String id;

    @NotNull
    private BigDecimal amount;
    @NotNull
    private PaymentType paymentType;
    @NotNull
    private String description;
}
