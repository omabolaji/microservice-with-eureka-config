package com.famousb.subscription.domain.response;

import lombok.Data;

@Data
public class GeneralResponse {
    private String message;
    private boolean success;
    private Object data;
}
