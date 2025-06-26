package src.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private static List<String> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public void logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logs.add(timestamp + " " + activity);
    }

    public String getLogs() {
        return String.join("\n", logs);
    }

    public static void clearLogs() {
        logs.clear();
    }
}