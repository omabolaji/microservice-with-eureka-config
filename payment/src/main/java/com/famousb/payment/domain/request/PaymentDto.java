package com.famousb.payment.domain.request;

import com.famousb.payment.domain.constant.PaymentType;
import com.famousb.payment.model.Customer;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PaymentDto {
    @NotNull @Min(5)
    private BigDecimal amount;
    @NotNull
    private String description;
    @NotNull
    private PaymentType paymentType;
    private Customer user;
}
