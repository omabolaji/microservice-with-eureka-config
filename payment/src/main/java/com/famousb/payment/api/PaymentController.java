package com.famousb.payment.api;

import com.famousb.payment.domain.constant.PaymentType;
import com.famousb.payment.domain.mapper.PaymentMapper;
import com.famousb.payment.domain.request.PaymentDto;
import com.famousb.payment.domain.response.PaymentView;
import com.famousb.payment.domain.utility.Utility;
import com.famousb.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private  PaymentMapper paymentMapper;


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createPayment(@RequestBody @Valid PaymentDto data){
        try{
            PaymentView paymentView = paymentService.createPayment(data);
            if(paymentView == null){
                return Utility.errorResponse(null,"Field ar required", HttpStatus.BAD_REQUEST,null);
            }
            return Utility.successResponse(paymentView,"Payment created!", HttpStatus.CREATED,null);
        }catch (Exception ex){
            return Utility.errorResponse(null,ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity<Object> getAllPayment(){
        try {
            List<PaymentView> paymentViews = paymentService.getAllPayment();
            return Utility.successResponse(paymentViews,"Payment found",HttpStatus.OK,null );
        }catch (Exception ex){
            return Utility.errorResponse(null,ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getByPaymentId(@PathVariable String id){
        try {
            PaymentView paymentView = paymentService.getPaymentById(id);
            return Utility.successResponse(paymentView,"Payment found",HttpStatus.OK,null );
        }catch (Exception ex){
            return Utility.errorResponse(null,ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }

    @GetMapping(path = "/type/{type}")
    public ResponseEntity<Object> getByPaymentType(@PathVariable PaymentType type){
        try {
            List<PaymentView> paymentViews = paymentService.getPaymentByType(type);
            return Utility.successResponse(paymentViews,"Payment found",HttpStatus.OK,null );
        }catch (Exception ex){
            return Utility.errorResponse(null,ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }

    @GetMapping(path = "/user/email/{email}")
    public ResponseEntity<Object> getPaymentByUserEmail(@PathVariable String email){
        try {
            List<PaymentView> paymentViews = paymentService.getPaymentByUserEmail(email);
            return Utility.successResponse(paymentViews,"Payment found",HttpStatus.OK,null );
        }catch (Exception ex){
            return Utility.errorResponse(null,ex.getMessage(), HttpStatus.BAD_REQUEST,null);
        }
    }
}
