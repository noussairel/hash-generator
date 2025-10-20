import java.time.Instant;

public class SimpleLogger {
    private final String name;

    private SimpleLogger(Class<?> clazz) {
        this.name = clazz.getSimpleName();
    }

    public static SimpleLogger getLogger(Class<?> clazz) {
        return new SimpleLogger(clazz);
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        String timestamp = Instant.now().toString(); // ISO-8601 UTC with "Z"
        System.out.printf("%s [%s] %s - %s%n", timestamp, level, name, message);
    }
}