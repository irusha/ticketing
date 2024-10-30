package com.ticker.ticketing.core;

import com.ticker.ticketing.TicketingApplication;
import com.ticker.ticketing.util.consolereader.CLIReaderUtil;
import com.ticker.ticketing.util.consolereader.ConsoleReaderConfig;
import com.ticker.ticketing.util.consolereader.ConsoleReaderException;
import com.ticker.ticketing.util.exception.InvalidConfigException;
import com.ticker.ticketing.util.parser.StringParser;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainRunnable implements Runnable {
    private final String[] args;
    private static volatile Runnable INSTANCE = null;

    private MainRunnable(String[] args) {
        this.args = args;
    }

    public static Runnable getInstance(String[] args) {
        if (INSTANCE == null) {
            synchronized (MainRunnable.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MainRunnable(args);
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public void run() {
        ConfigurableApplicationContext springContext = null;
        ConsoleReaderConfig config = new ConsoleReaderConfig.Builder()
                .setInputMessage("Please enter an option")
                .setInputCompletedMessageFunction((val) -> "Accepted value: " + val)
                .setRetryMessage("Invalid Value, Please try again.")
                .build();
        while (true) {
            try {
                String input = CLIReaderUtil.readValue(config, val -> "START_SPRINGBOOT".equals(val) || "STOP_SPRINGBOOT".equals(val), new StringParser());
                System.out.println(input);

                if ("START_SPRINGBOOT".equals(input) && (springContext == null || !springContext.isActive())) {
                    springContext = SpringApplication.run(TicketingApplication.class, args);
                } else if ("STOP_SPRINGBOOT".equals(input) && springContext != null) {
                    springContext.close();
                } else if ("EXIT".equals(input)) {
                    if (springContext != null) {
                        springContext.close();
                    }
                    System.exit(0);
                }
            } catch (ConsoleReaderException | InvalidConfigException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
