package com.ticker.ticketing.util.consolereader;

import com.ticker.ticketing.util.Constants;
import com.ticker.ticketing.util.consolewriter.ConsoleWriter;
import com.ticker.ticketing.util.consolewriter.ConsoleWriterFactory;
import com.ticker.ticketing.util.exception.InvalidConfigException;

import java.util.Scanner;

public class CLIReaderUtil {
    public static <T> T readValue(ConsoleReaderConfig config, ValidationProcessor validationProcessor, ValueParser<T> valueParser) throws ConsoleReaderException, InvalidConfigException {
        Scanner scanner = new Scanner(System.in);
        T parsedValue = null;
        int tries = 0;

        if (config.isThrowExceptionUponInputError() && config.getInputError() == null) {
            throw new InvalidConfigException(Constants.CONSOLE_READER_CONF_EXCEPTION_MISMATCH_MESSAGE);
        } else if (config.getMaxRetryCount() != Integer.MAX_VALUE && config.isThrowExceptionUponInputError()) {
            throw new InvalidConfigException(Constants.CONSOLE_READER_CONF_EXCEPTION_MAX_RETRY_WITH_VALIDATION_ERRORS);
        }

        ConsoleWriter writer = ConsoleWriterFactory.getWriter();
        writer.write(config.getInputMessage());
        while (parsedValue == null) {
            tries++;
            String scannedValue = scanner.nextLine();
            if (validationProcessor.validate(scannedValue)) {
                parsedValue = valueParser.parse(scannedValue);
            } else {
                if (config.isThrowExceptionUponInputError() && config.getInputError() != null) {
                    throw config.getInputError();
                } else {
                    if (config.getMaxRetryCount() != Integer.MAX_VALUE && tries == config.getMaxRetryCount()) {
                        throw new ConsoleReaderException(Constants.MAX_RETRY_COUNT_EXCEEDED);
                    }
                    else {
                        writer.write(config.getRetryMessage());
                    }
                }
            }
        }

        if (config.getInputCompletedMessageFunction() != null) {
            writer.write(config.getInputCompletedMessageFunction().apply(parsedValue.toString()));
        }
        return parsedValue;
    }
}
