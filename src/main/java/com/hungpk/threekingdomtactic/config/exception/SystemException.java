package com.hungpk.threekingdomtactic.config.exception;

import lombok.Getter;

public class SystemException extends RuntimeException {
    @Getter
    private Object[] args;
    public SystemException(String message) {
        super(message);
        this.args = null;
    }

    public SystemException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
