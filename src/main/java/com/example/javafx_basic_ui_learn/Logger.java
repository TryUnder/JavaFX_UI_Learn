package com.example.javafx_basic_ui_learn;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE = "transaction_log.txt";

    public static void logTransaction(int quantitySold, String bookTitle, String clientDetails) {
        String logMessage = formatLogMessage(quantitySold, bookTitle, clientDetails);
        writeLogToFile(logMessage);
    }

    private static String formatLogMessage(int quantitySold, String bookTitle, String clientDetails) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        return String.format("[%s] Sold %d units of '%s' to %s", timestamp, quantitySold, bookTitle, clientDetails);
    }

    private static void writeLogToFile(String logMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logMessage);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
