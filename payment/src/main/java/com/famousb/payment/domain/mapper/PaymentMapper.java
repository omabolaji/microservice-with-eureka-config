package com.famousb.payment.domain.mapper;

import com.famousb.payment.domain.request.PaymentDto;
import com.famousb.payment.domain.response.PaymentView;
import com.famousb.payment.model.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class})
public abstract class PaymentMapper {

    public abstract PaymentView viewPayment(Payment payment);
    public abstract List<PaymentView> viewPayment(List<Payment> payments);
    public abstract Payment create(PaymentDto dto);

}
