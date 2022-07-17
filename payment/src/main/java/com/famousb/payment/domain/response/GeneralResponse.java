package com.famousb.payment.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralResponse {
    private String message;
    private boolean success;
    private Object data;
}
