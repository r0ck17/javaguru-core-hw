package module6Multithreading.topic2CallableAndThreadPool;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 *                          Генератор чисел
 *
 * 1. Создать задачу Callable, которая генерирует коллекцию из 10 случайных целых чисел
 *          - засыпает произвольно на 1-10 секунд,
 *          - результат выполнения – сумма этих чисел в виде строки.
 *
 * 2. Запустить 10 задач параллельно в пуле из 3 потоков.
 * 3. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
 */

public class Task_2 {
    private static final int THREADS_COUNT = 3;
    private static final int TASKS_COUNT = 10;

    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < TASKS_COUNT; i++) {
            Future<String> submit = pool.submit(new NumberGenerator());
            futures.add(submit);
        }

        List<String> resultList = new ArrayList<>();

        for (Future<String> number : futures) {
            resultList.add(number.get());
        }

        pool.shutdown();
        System.out.println("\n" + resultList);
        System.out.println("Collection total size: " + resultList.size());
    }
}

class NumberGenerator implements Callable<String> {
    private static final int NUMBERS_COUNT = 10;

    @Override
    public String call() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s is started.\n", threadName);

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            int num = random.nextInt(10);
            numbers.add(num);
        }

        int seconds = random.nextInt(9) + 1;
        System.out.printf("%s now sleep for %d seconds.\n", threadName, seconds);
        TimeUnit.SECONDS.sleep(seconds);

        System.out.printf("%s is done.\n", threadName);

        return sumNumbers(numbers);
    }

    private String sumNumbers(List<Integer> nums) {
        long sum = 0;

        for (Integer num : nums) {
            sum += num;
        }

        return Long.toString(sum);
    }
}
