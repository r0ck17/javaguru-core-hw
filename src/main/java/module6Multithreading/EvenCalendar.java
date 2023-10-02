package module6Multithreading;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * Создать Callable класс, метод call считает, сколько секунд осталось от
 * текущей даты до переданной даты и выводит на консоль каждую секунду сообщение:
 * "Event =threadName= will be started in =seconds= seconds"
 *
 * Когда указанное время наступает, то поток завершает выполнение и возвращает
 * return "Event =threadName= started."
 *
 * Сделать пул из 10 потоков и вызвать
 *
 * Разницу в секундах можно считать Duration.between(dateTime.LocalDateTime(now)).toSeconds)
 *
 */
public class EvenCalendar {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        LocalDateTime now = LocalDateTime.now();

        Callable<String> eventHandler1 = new EventHandler(now.plusSeconds(5));
        Callable<String> eventHandler2 = new EventHandler(now.plusSeconds(7));
        Callable<String> eventHandler3 = new EventHandler(now.plusSeconds(9));
        Callable<String> eventHandler4 = new EventHandler(now.plusSeconds(12));
        Callable<String> eventHandler5 = new EventHandler(now.plusSeconds(15));

        Future<String> res1 = pool.submit(eventHandler1);
        Future<String> res2 = pool.submit(eventHandler2);
        Future<String> res3 = pool.submit(eventHandler3);
        Future<String> res4 = pool.submit(eventHandler4);
        Future<String> res5 = pool.submit(eventHandler5);

        System.out.println(res1.get());
        System.out.println(res2.get());
        System.out.println(res3.get());
        System.out.println(res4.get());
        System.out.println(res5.get());

        pool.shutdown();
    }
}

class EventHandler implements Callable {
    private LocalDateTime eventDate;

    public EventHandler(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String call() throws InterruptedException {
        long seconds = 0;
        while ((seconds = Duration.between(LocalDateTime.now(), eventDate).toSeconds()) >= 0) {
            System.out.printf(
                    "Event %s will be started in %d seconds\n",
                    Thread.currentThread().getName(),
                    seconds);
            TimeUnit.SECONDS.sleep(1);
        }

        return String.format("Event %s started.", Thread.currentThread().getName());
    }
}
