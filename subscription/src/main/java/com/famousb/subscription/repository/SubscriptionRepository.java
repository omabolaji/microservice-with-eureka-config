package com.famousb.subscription.repository;

import com.famousb.subscription.model.Subscription;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, ObjectId> {

    Optional<Subscription> findByName(String name);
    Optional<Subscription> findByPaymentId(String id);
    Optional<Subscription> findByUserId(String id);
}
