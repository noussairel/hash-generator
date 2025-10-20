package com.noussair.todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class PeriodicLogger {
    private static final Logger logger = LoggerFactory.getLogger(PeriodicLogger.class);
    private final RandomIdService ids;

    public PeriodicLogger(RandomIdService ids){
        this.ids = ids;
    }

    @Scheduled(fixedRateString = "${LOG_PERIOD_MS:5000}", initialDelayString = "${LOG_INITIAL_DELAY_MS:0}")
    public void logId(){
        logger.info("{}: {}", Instant.now().toString(), ids.getId());
    }
}
