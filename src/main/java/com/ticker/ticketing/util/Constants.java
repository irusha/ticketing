package com.ticker.ticketing.util;

public class Constants {
    public static final String CONSOLE_READER_CONF_EXCEPTION_MISMATCH_MESSAGE = "Errors upon failed validations are on but the exception is null in the console reader config";
    public static final String SYSTEM_OUT = "SYSTEM_OUT";
    public static final String NO_NEGATIVE_RETRY_COUNT_ERROR = "maxRetryCount must be greater than 0";
    public static final String MAX_RETRY_COUNT_EXCEEDED = "Maximum retry count exceeded";
    public static final String CONSOLE_READER_CONF_EXCEPTION_MAX_RETRY_WITH_VALIDATION_ERRORS = "Max retry configuration should not be configured with ThrowExceptionUponInputError";

    private Constants() {}

}
