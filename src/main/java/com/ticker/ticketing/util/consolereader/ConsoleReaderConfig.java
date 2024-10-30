package com.ticker.ticketing.util.consolereader;

import com.ticker.ticketing.util.Constants;

import java.util.function.Function;

public class ConsoleReaderConfig {
    private String inputMessage;
    private String retryMessage;
    private Function<String, String> inputCompletedMessageFunction;
    private ConsoleReaderException inputError;
    private boolean throwExceptionUponInputError;
    private int maxRetryCount;

    public ConsoleReaderConfig(Builder builder) {
        this(builder.inputMessage, builder.retryMessage, builder.inputError, builder.throwExceptionUponInputError, builder.inputCompletedMessageFunction, builder.maxRetryCount);
    }

    public ConsoleReaderConfig(String inputMessage, String retryMessage, ConsoleReaderException inputError, boolean throwExceptionUponInputError, Function<String, String> inputCompletedMessageFunction, int maxRetryCount) {
        if (maxRetryCount < 1) {
            throw new IllegalArgumentException(Constants.NO_NEGATIVE_RETRY_COUNT_ERROR);
        }

        this.inputMessage = inputMessage;
        this.retryMessage = retryMessage;
        this.inputCompletedMessageFunction = inputCompletedMessageFunction;
        this.inputError = inputError;
        this.throwExceptionUponInputError = throwExceptionUponInputError;
        this.maxRetryCount = maxRetryCount;
    }

    public ConsoleReaderConfig(String inputMessage, String retryMessage) {
        this(inputMessage, retryMessage, null, false, null, Integer.MAX_VALUE);
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

    public int getMaxRetryCount() {
        return maxRetryCount;
    }

    public void setMaxRetryCount(int maxRetryCount) {
        if (maxRetryCount < 1) {
            throw new IllegalArgumentException(Constants.NO_NEGATIVE_RETRY_COUNT_ERROR);
        }
        this.maxRetryCount = maxRetryCount;
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
        private int maxRetryCount = Integer.MAX_VALUE;

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

        public Builder setMaxRetryCount(int maxRetryCount) {
            if (maxRetryCount < 1) {
                throw new IllegalArgumentException(Constants.NO_NEGATIVE_RETRY_COUNT_ERROR);
            }

            this.maxRetryCount = maxRetryCount;
            return this;
        }

        public ConsoleReaderConfig build() {
            return new ConsoleReaderConfig(this);
        }
    }
}
