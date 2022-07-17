package com.famousb.subscription.domain.mapper;


import com.famousb.subscription.domain.ObjectIdMapper;
import com.famousb.subscription.domain.request.SubscriptionDto;
import com.famousb.subscription.domain.response.SubscriptionView;
import com.famousb.subscription.model.Subscription;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public abstract class SubscriptionMapper {

    public abstract SubscriptionView subscriptionView(Subscription subscription);
    public abstract List<SubscriptionView> subscriptionView(List<Subscription> subscriptions);
    public abstract Subscription create(SubscriptionDto dto);
}
