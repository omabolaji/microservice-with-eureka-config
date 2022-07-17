package com.famousb.payment.model;

import com.famousb.payment.domain.constant.PaymentType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "payment")
@Data
public class Payment implements Serializable {
    @Id
    private ObjectId id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @NotNull
    private BigDecimal amount;
    @NotNull
    private String description;
    @NotNull
    private PaymentType paymentType;
    @Indexed
    private Customer user;

}
