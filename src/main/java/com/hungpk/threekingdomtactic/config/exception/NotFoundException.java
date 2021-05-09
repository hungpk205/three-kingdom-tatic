package com.hungpk.threekingdomtactic.config.exception;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private Object[] args;
    public NotFoundException(String message) {
        super(message);
        this.args = null;
    }

    public NotFoundException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
