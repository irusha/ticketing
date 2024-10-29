package com.ticker.ticketing.util.exception;

public class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }

    public InvalidConfigException(String message, Throwable cause) {}

    public InvalidConfigException(Throwable cause) {}

    public InvalidConfigException() {}
}
