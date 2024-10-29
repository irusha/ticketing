package com.ticker.ticketing;

import com.ticker.ticketing.core.MainRunnable;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketingApplication {

    public static void main(String[] args) {
        Runnable runnable = MainRunnable.getInstance(args);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
