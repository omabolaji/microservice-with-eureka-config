package com.famousb.payment.service;

import com.famousb.payment.domain.constant.PaymentType;
import com.famousb.payment.domain.mapper.PaymentMapper;
import com.famousb.payment.domain.request.PaymentDto;
import com.famousb.payment.domain.response.PaymentView;
import com.famousb.payment.model.Customer;
import com.famousb.payment.model.Payment;
import com.famousb.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional
    public PaymentView createPayment(PaymentDto payment) throws Exception {
        Customer customer = userService.getUserDetail(payment.getUser().getEmail());
        if(customer == null){
            throw new Exception("User profile not found");
        }
        payment.setUser(customer);
        return paymentMapper.viewPayment(paymentRepository.save(paymentMapper.create(payment)));
    }

    public PaymentView getPaymentById(String id){
        Optional<Payment> payment = paymentRepository.findById(new ObjectId(id));
        if(payment.isEmpty()){
            return null;
        }
        return paymentMapper.viewPayment(payment.get());
    }

    public List<PaymentView> getPaymentByUserEmail(String email){
        List<Payment> payment = paymentRepository.findAllByUserEmail(email);
        if(payment.isEmpty()){
            return null;
        }
        return paymentMapper.viewPayment(payment);
    }

    public List<PaymentView> getPaymentByType(PaymentType type){
        List<Payment> payments = paymentRepository.findAllByPaymentType(type);
        if (payments.size() < 1){
            return null;
        }
        return paymentMapper.viewPayment(payments);
    }

    public List<PaymentView> getAllPayment(){
        List<Payment> payments = paymentRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return paymentMapper.viewPayment(payments);
    }
}
