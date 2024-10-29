package com.ticker.ticketing.core;

import com.ticker.ticketing.TicketingApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

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
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(input);

            if ("START_SPRINGBOOT".equals(input) && (springContext == null || !springContext.isActive()) ) {
                 springContext = SpringApplication.run(TicketingApplication.class, args);
            }

            else if ("STOP_SPRINGBOOT".equals(input) && springContext != null) {
                springContext.close();
            }
            else if ("EXIT".equals(input)) {
                if(springContext != null) {
                    springContext.close();
                }
                System.exit(0);
            }
        }
    }
}
