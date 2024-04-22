package com.example.demo.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.time.Instant;

public class Logger {

    public static final org.apache.logging.log4j.Logger log = LogManager.getLogger();
    private static final Marker CSV_MARKER = MarkerManager.getMarker("CSV");

    public Logger() {
    }

    public void logToCsv(Number userId, String service, String message, String code) {
        log.debug(CSV_MARKER, "CSV Logs", Instant.now(), userId, service, message, code);
    }
}
