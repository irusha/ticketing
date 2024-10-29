package com.ticker.ticketing.util.consolereader;

import com.ticker.ticketing.util.Constants;
import com.ticker.ticketing.util.consolewriter.ConsoleWriter;
import com.ticker.ticketing.util.consolewriter.ConsoleWriterFactory;
import com.ticker.ticketing.util.exception.InvalidConfigException;

import java.util.Scanner;

public class CLIReaderUtil {
    public static <T> T readValue(ConsoleReaderConfig config, ValidationProcessor validationProcessor, ValueParser<T> valueParser) throws ConsoleReaderException, InvalidConfigException {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        ConsoleWriter writer = ConsoleWriterFactory.getWriter();
        writer.write(config.getInputMessage());
        while (input == null) {
            String scannedValue = scanner.nextLine();
            if (validationProcessor.validate(scannedValue)) {
                input = scannedValue;
            } else {
                if (config.isThrowExceptionUponInputError() && config.getInputError() != null) {
                    throw config.getInputError();
                } else if (config.isThrowExceptionUponInputError() && config.getInputError() == null) {
                    throw new InvalidConfigException(Constants.CONSOLE_READER_CONF_EXCEPTION_MISMATCH_MESSAGE);
                } else {
                    writer.write(config.getRetryMessage());
                }
            }
        }

        T parsedVal = valueParser.parse(input);

        if (config.getInputCompletedMessageFunction() != null) {
            writer.write(config.getInputCompletedMessageFunction().apply(parsedVal.toString()));
        }

        return parsedVal;
    }
}
