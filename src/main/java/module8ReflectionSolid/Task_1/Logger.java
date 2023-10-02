package module8ReflectionSolid.Task_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Logger {
    private static volatile Logger instance;
    private final Level loggerLevel;

    private Logger(Level level) {
        this.loggerLevel = level;
    }

    public static Logger getLogger(Level level) {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger(level);
                }
            }
        }
        return instance;
    }

    public void log(Level messageLevel, String message) {
        try {
            if (messageLevel.ordinal() >= loggerLevel.ordinal()) {
                LocalDateTime now = LocalDateTime.now();
                Path path = Path.of(String.format(
                        "%s.txt",
                        now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                String line = String.format(
                        "[%s] %s %s%n",
                        messageLevel,
                        now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
                        message);
                Files.writeString(path, line, CREATE, APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum Level {
        TRACE, DEBUG, INFO, WARN, ERROR, FATAL
    }
}