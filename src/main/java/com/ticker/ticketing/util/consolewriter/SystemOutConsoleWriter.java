package com.ticker.ticketing.util.consolewriter;

public class SystemOutConsoleWriter implements ConsoleWriter {
    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
