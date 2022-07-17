package com.famousb.payment.domain.response;

import com.famousb.payment.domain.constant.PaymentType;
import com.famousb.payment.model.Customer;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentView implements Serializable {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private BigDecimal amount;
    private String description;
    private PaymentType paymentType;
    private Customer user;
}
