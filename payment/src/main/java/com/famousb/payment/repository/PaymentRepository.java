package com.famousb.payment.repository;

import com.famousb.payment.domain.constant.PaymentType;
import com.famousb.payment.model.Payment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, ObjectId> {

    Optional<Payment> findByPaymentType(PaymentType type);
    Optional<Payment> findByUserEmail(String email);
    List<Payment> findAllByUserEmail(String email);
    List<Payment> findAllByPaymentType(PaymentType email);
}
