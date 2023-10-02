package module6Multithreading.topic3finalTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.*;

public class EventHandler implements Callable<Void> {
    private Map<String, Event> events;
    private final NotificationTypeMode eventHandlerMode;

    public EventHandler(Map<String, Event> events,
                        NotificationTypeMode eventHandlerMode) {
        this.events = events;
        this.eventHandlerMode = eventHandlerMode;
    }

    @Override
    public Void call() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s[%s] started. %n", threadName, eventHandlerMode);

        switch (eventHandlerMode) {
            case ACTIVE_EVENTS:
                printAllActiveEvents();
                break;
            case STARTING_EVENTS:
                printStartingEvents();
                break;
            case START_WITHIN_HOUR:
                printEventsStartWithinHour();
                break;
            default:
                break;
        }
        
        return null;
    }

    private void printEventsStartWithinHour() {
        while (true) {
            for (var event : events.entrySet()) {
                Duration duration = Duration.between(LocalDateTime.now(),
                        event.getValue().getDate());
                long minutesToStart = duration.toMinutes();
                if (!event.getValue().isActive() && minutesToStart < 60) {
                    System.out.printf("Event [%s] will be started in %d:%d.%n",
                            event.getKey(),
                            minutesToStart,
                            duration.getSeconds() % 60);
                }
            }

            try {
                SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printStartingEvents() {
        while (true) {
            for (var event : events.entrySet()) {
                long seconds = Duration.between(LocalDateTime.now(),
                        event.getValue().getDate()).toSeconds();
                if (seconds <= 0 && !event.getValue().isActive()) {
                    event.getValue().setActive(true);
                    System.out.printf("%nEvent [%s - ] is now active.%n%n",
                            event.getKey(), event.getValue().getDescription());
                }
            }
            try {
                MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printAllActiveEvents() {
        while (true) {
            System.out.println();
            for (var event : events.entrySet()) {
                if (event.getValue().isActive()) {
                    System.out.printf("Event [%s] is already started!%n",
                            event.getKey());
                }
            }
            System.out.println();

            try {
                SECONDS.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
