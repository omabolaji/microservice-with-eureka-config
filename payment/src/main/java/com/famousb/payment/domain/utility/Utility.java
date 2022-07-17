package com.famousb.payment.domain.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class Utility {

    public static ResponseEntity<Object> successResponse(Object data, String message, HttpStatus status, HashMap<String, String> headers){
        return getObjectResponseEntity(ResponseEntity.status(status),true, data, message, headers);
    }

    public static ResponseEntity<Object> errorResponse(Object data, String message, HttpStatus status, HashMap<String, String> headers){
        return getObjectResponseEntity(ResponseEntity.status(status),false, data, message, headers);
    }

    private static ResponseEntity<Object> getObjectResponseEntity(ResponseEntity.BodyBuilder status2, boolean success, Object data, String message, HashMap<String, String> headers) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("success", success);
        body.put("message", message);
        body.put("data", data);

        HttpHeaders hs = new HttpHeaders();
        if(headers != null){
            headers.forEach(hs::add);
        }
        return status2.headers(hs).body(body);
    }
}
