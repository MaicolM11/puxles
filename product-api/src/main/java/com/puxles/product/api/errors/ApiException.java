package com.puxles.product.api.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
 
    private HttpStatus statusCode;

    private String message;

    private List<String> errors;

    public ApiException(HttpStatus errorType, String message) {
        super(message);
        this.statusCode = errorType;
        this.message = message;
        this.errors = new ArrayList<>();
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    


}
