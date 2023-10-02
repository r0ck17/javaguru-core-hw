package module6Multithreading.topic3finalTask;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Event {
    private final String name;
    private final String description;
    private final LocalDateTime date;
    private boolean isActive;

    public Event(String name, String description, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
