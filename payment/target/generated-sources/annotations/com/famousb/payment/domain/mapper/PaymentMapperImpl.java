package com.famousb.payment.domain.mapper;

import com.famousb.payment.domain.request.PaymentDto;
import com.famousb.payment.domain.response.PaymentView;
import com.famousb.payment.model.Payment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T14:56:49+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl extends PaymentMapper {

    @Autowired
    private ObjectIdMapper objectIdMapper;

    @Override
    public PaymentView viewPayment(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentView paymentView = new PaymentView();

        paymentView.setId( objectIdMapper.objectIdToString( payment.getId() ) );
        paymentView.setCreatedAt( payment.getCreatedAt() );
        paymentView.setModifiedAt( payment.getModifiedAt() );
        paymentView.setAmount( payment.getAmount() );
        paymentView.setDescription( payment.getDescription() );
        paymentView.setPaymentType( payment.getPaymentType() );
        paymentView.setUser( payment.getUser() );

        return paymentView;
    }

    @Override
    public List<PaymentView> viewPayment(List<Payment> payments) {
        if ( payments == null ) {
            return null;
        }

        List<PaymentView> list = new ArrayList<PaymentView>( payments.size() );
        for ( Payment payment : payments ) {
            list.add( viewPayment( payment ) );
        }

        return list;
    }

    @Override
    public Payment create(PaymentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setAmount( dto.getAmount() );
        payment.setDescription( dto.getDescription() );
        payment.setPaymentType( dto.getPaymentType() );
        payment.setUser( dto.getUser() );

        return payment;
    }
}
