package com.ticker.ticketing.util.consolewriter;

import com.ticker.ticketing.util.ServiceConfiguration;

import com.ticker.ticketing.util.*;

public class ConsoleWriterFactory {
    private ConsoleWriterFactory() {

    }

    public static ConsoleWriter getWriter() {
        switch (ServiceConfiguration.DEFAULT_CONSOLE_WRITER) {
            case Constants.SYSTEM_OUT:
                return new SystemOutConsoleWriter();
            default:
                return new SystemOutConsoleWriter();
        }
    }
}
