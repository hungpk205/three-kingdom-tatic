package com.hungpk.threekingdomtactic.config.exception;

import lombok.Getter;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private Object[] args;
    public ValidationException(String message) {
        super(message);
        this.args = null;
    }

    public ValidationException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
