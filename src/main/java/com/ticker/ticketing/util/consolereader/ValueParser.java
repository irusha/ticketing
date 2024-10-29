package com.ticker.ticketing.util.consolereader;

public interface ValueParser<T> {
    public abstract T parse(String value);
}
