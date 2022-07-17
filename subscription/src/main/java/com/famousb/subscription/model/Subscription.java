package com.famousb.subscription.model;

import com.famousb.subscription.domain.constant.SubscriptionType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @Document(collection = "subscription")
public class Subscription {
    @Id
    private ObjectId id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private LocalDate expiryDate;
    @NotNull
    private SubscriptionType type;
    @Indexed
    private Customer user;
    @Indexed
    private Payment payment;
}
