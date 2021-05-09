package com.hungpk.threekingdomtactic.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class RestApiErrorResponse {
    private HttpStatus status;
    private List<String> errors;

    public RestApiErrorResponse(HttpStatus status, String errors) {
        this.status = status;
        this.errors = List.of(errors);
    }

    public RestApiErrorResponse(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }
}
