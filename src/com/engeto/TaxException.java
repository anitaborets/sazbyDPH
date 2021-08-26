package com.engeto;

public class TaxException extends Exception {
    public TaxException() {
    }

    public TaxException(String message) {
        super(message);
    }

    public TaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxException(Throwable cause) {
        super(cause);
    }

    public TaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}