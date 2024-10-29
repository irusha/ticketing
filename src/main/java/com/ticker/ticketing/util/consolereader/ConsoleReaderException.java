package com.ticker.ticketing.util.consolereader;

public class ConsoleReaderException extends Exception {
    public ConsoleReaderException() {
        super();
    }

    public ConsoleReaderException(String message) {
        super(message);
    }

    public ConsoleReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
