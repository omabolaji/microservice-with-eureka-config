package com.famousb.subscription.domain.mapper;

import com.famousb.subscription.domain.ObjectIdMapper;
import com.famousb.subscription.domain.request.SubscriptionDto;
import com.famousb.subscription.domain.response.SubscriptionView;
import com.famousb.subscription.model.Subscription;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T15:35:45+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class SubscriptionMapperImpl extends SubscriptionMapper {

    @Autowired
    private ObjectIdMapper objectIdMapper;

    @Override
    public SubscriptionView subscriptionView(Subscription subscription) {
        if ( subscription == null ) {
            return null;
        }

        SubscriptionView subscriptionView = new SubscriptionView();

        subscriptionView.setId( objectIdMapper.objectIdToString( subscription.getId() ) );
        subscriptionView.setCreatedAt( subscription.getCreatedAt() );
        subscriptionView.setModifiedAt( subscription.getModifiedAt() );
        subscriptionView.setName( subscription.getName() );
        subscriptionView.setDescription( subscription.getDescription() );
        subscriptionView.setExpiryDate( subscription.getExpiryDate() );
        subscriptionView.setType( subscription.getType() );
        subscriptionView.setUser( subscription.getUser() );
        subscriptionView.setPayment( subscription.getPayment() );

        return subscriptionView;
    }

    @Override
    public List<SubscriptionView> subscriptionView(List<Subscription> subscriptions) {
        if ( subscriptions == null ) {
            return null;
        }

        List<SubscriptionView> list = new ArrayList<SubscriptionView>( subscriptions.size() );
        for ( Subscription subscription : subscriptions ) {
            list.add( subscriptionView( subscription ) );
        }

        return list;
    }

    @Override
    public Subscription create(SubscriptionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Subscription subscription = new Subscription();

        subscription.setName( dto.getName() );
        subscription.setDescription( dto.getDescription() );
        subscription.setExpiryDate( dto.getExpiryDate() );
        subscription.setType( dto.getType() );
        subscription.setUser( dto.getUser() );
        subscription.setPayment( dto.getPayment() );

        return subscription;
    }
}
