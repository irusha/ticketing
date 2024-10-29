package com.ticker.ticketing.util.consolereader;

import java.util.function.Function;

public class ConsoleReaderConfig {
    private String inputMessage;
    private String retryMessage;
    private Function<String, String> inputCompletedMessageFunction;
    private ConsoleReaderException inputError;
    private boolean throwExceptionUponInputError;

    public ConsoleReaderConfig(Builder builder) {
        this.inputMessage = builder.inputMessage;
        this.retryMessage = builder.retryMessage;
        this.inputCompletedMessageFunction = builder.inputCompletedMessageFunction;
        this.inputError = builder.inputError;
        this.throwExceptionUponInputError = builder.throwExceptionUponInputError;
    }

    public ConsoleReaderConfig(String inputMessage, String retryMessage, ConsoleReaderException inputError, boolean throwExceptionUponInputError, Function<String, String> inputCompletedMessageFunction) {
        this.inputMessage = inputMessage;
        this.retryMessage = retryMessage;
        this.inputCompletedMessageFunction = inputCompletedMessageFunction;
        this.inputError = inputError;
        this.throwExceptionUponInputError = throwExceptionUponInputError;
    }

    public ConsoleReaderConfig(String inputMessage, String retryMessage) {
        this.inputMessage = inputMessage;
        this.retryMessage = retryMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public void setRetryMessage(String retryMessage) {
        this.retryMessage = retryMessage;
    }

    public void setInputCompletedMessageFunction(Function<String, String> inputCompletedMessageFunction) {
        this.inputCompletedMessageFunction = inputCompletedMessageFunction;
    }

    public void setInputError(ConsoleReaderException inputError) {
        this.inputError = inputError;
    }

    public String getRetryMessage() {
        return retryMessage == null ? inputMessage : retryMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public Function<String, String> getInputCompletedMessageFunction() {
        return inputCompletedMessageFunction;
    }

    public ConsoleReaderException getInputError() {
        return inputError;
    }

    public boolean isThrowExceptionUponInputError() {
        return throwExceptionUponInputError;
    }

    public void setThrowExceptionUponInputError(boolean throwExceptionUponInputError) {
        this.throwExceptionUponInputError = throwExceptionUponInputError;
    }

    public static class Builder {
        private String inputMessage;
        private String retryMessage;
        private Function<String, String> inputCompletedMessageFunction;
        private ConsoleReaderException inputError;
        private boolean throwExceptionUponInputError;

        public Builder setInputMessage(String inputMessage) {
            this.inputMessage = inputMessage;
            return this;
        }

        public Builder setRetryMessage(String retryMessage) {
            this.retryMessage = retryMessage;
            return this;
        }

        public Builder setInputCompletedMessageFunction(Function<String, String> inputCompletedMessageFunction) {
            this.inputCompletedMessageFunction = inputCompletedMessageFunction;
            return this;
        }

        public Builder setInputError(ConsoleReaderException inputError) {
            this.inputError = inputError;
            return this;
        }

        public Builder setThrowExceptionUponInputError(boolean throwExceptionUponInputError) {
            this.throwExceptionUponInputError = throwExceptionUponInputError;
            return this;
        }

        public ConsoleReaderConfig build() {
            return new ConsoleReaderConfig(this);
        }
    }
}
