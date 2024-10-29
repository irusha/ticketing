package com.ticker.ticketing.util.parser;

import com.ticker.ticketing.util.consolereader.ValueParser;

public class StringParser implements ValueParser<String> {
    @Override
    public String parse(String value) {
        return value;
    }
}
