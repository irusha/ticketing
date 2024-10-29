package com.ticker.ticketing.util.parser;

import com.ticker.ticketing.util.consolereader.ValueParser;

public class IntParser implements ValueParser<Integer> {
    @Override
    public Integer parse(String value) {
        return Integer.parseInt(value);
    }
}
