package com.famousb.subscription.service;

import com.famousb.subscription.domain.constant.SubscriptionType;
import com.famousb.subscription.domain.mapper.SubscriptionMapper;
import com.famousb.subscription.domain.request.SubscriptionDto;
import com.famousb.subscription.domain.response.SubscriptionView;
import com.famousb.subscription.model.Customer;
import com.famousb.subscription.model.Payment;
import com.famousb.subscription.model.Subscription;
import com.famousb.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserService userService;
    private final PaymentService paymentService;

    public SubscriptionView create(SubscriptionDto dto) throws Exception {
        Subscription subscription = subscriptionMapper.create(dto);
        LocalDate expiry = getExpiryDate(dto.getType());
        subscription.setExpiryDate(expiry);
        Customer customer = userService.getUserDetail(dto.getUser().getEmail());
        subscription.setUser(customer);
        Payment payment = paymentService.getPaymentById(dto.getPayment().getId());
        subscription.setPayment(payment);
        return subscriptionMapper.subscriptionView(subscriptionRepository.save(subscription));
    }

    private LocalDate getExpiryDate(SubscriptionType type) throws Exception {
        LocalDate localDate = LocalDate.now();
        switch (type.name()){
            case "WEEKLY":
                return localDate.plusWeeks(1);
            case "MONTHLY":
                return localDate.plusMonths(1);
            case "QUARTERLY":
                return localDate.plusMonths(3);
            case "SEMESTER":
                return localDate.plusMonths(6);
            case "YEARLY":
                return localDate.plusYears(1);
            default:
                throw new Exception("Subscription type not found");
        }
    }

    public List<SubscriptionView> getAllSubscription(){
        return subscriptionMapper.subscriptionView(subscriptionRepository
                .findAll(Sort.by(Sort.Direction.DESC, "createdAt")));
    }

}
