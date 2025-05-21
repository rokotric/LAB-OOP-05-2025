import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LibraryLogger {
    private List<String> logs = new ArrayList<>();

    //string
    public void logActivity(String activity) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(dtf);
        logs.add(timestamp + " " + activity);
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log aktivitas";
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
        
    }
    //buat clearlogs
}