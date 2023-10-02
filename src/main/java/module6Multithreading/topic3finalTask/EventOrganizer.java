package module6Multithreading.topic3finalTask;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.*;

/**
 *                          Органайзер мероприятий
 *
 * 1. Создайте карту мероприятий в формате Map<String, Event> , где
 *      - Key - уникальное имя мероприятия
 *      - Value - класс Event с полями:
 *                  String name,
 *                  LocalDateTime date,
 *                  String descriprion,
 *                  boolean isActive
 *
 * 2. Создайте Callable класс с логикой обработки карты мероприятий.
 *
 * 3. Новый поток этого класса можно создать в режимах:
 *      1) За час до старта любого из мероприятий в карте, начни каждую секунду выводить на консоль:
 *              Название мероприятия и время до старта
 *      2) Пришли нотификацию в момент начала любого мероприятия и установки isActive в true
 *      3) Присылай каждую минуту сообщение: Мероприятие уже началось! Для всех Event с isActive true
 */

public class EventOrganizer {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Event> events = getEvents();
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(new EventHandler(events, NotificationTypeMode.START_WITHIN_HOUR));
        pool.submit(new EventHandler(events, NotificationTypeMode.ACTIVE_EVENTS));
        pool.submit(new EventHandler(events, NotificationTypeMode.STARTING_EVENTS));

        SECONDS.sleep(25);
        pool.shutdownNow();
    }

    private static Map<String, Event> getEvents() {
        return new HashMap<>() {{
            put("Event #1", new Event("Event #1", "desc1",
                    LocalDateTime.now().plusSeconds(5)));
            put("Event #2", new Event("Event #2", "desc2",
                    LocalDateTime.now().plusSeconds(10)));
            put("Event #3", new Event("Event #3", "desc3",
                    LocalDateTime.now().plusSeconds(15)));
            put("Event #4", new Event("Event #4", "desc4",
                    LocalDateTime.now().plusMinutes(12)));
            put("Event #5", new Event("Event #5", "desc5",
                    LocalDateTime.now().plusMinutes(30)));
            put("Event #6", new Event("Event #6", "desc6",
                    LocalDateTime.now().plusMinutes(60)));
            put("Event #7", new Event("Event #7", "desc7",
                    LocalDateTime.now().plusMinutes(60).plusSeconds(20)));
        }};
    }
}
