package module6Multithreading.topic2CallableAndThreadPool;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Секундомер
 * <p>
 * 1. Создать задачу Callable, которая берет сообщение “Hello World” + текущее время и записывает его в файл.
 * 2. Запись в файл должна производиться последовательно через синхронизированный метод.
 * 3. Запустить 10 задач параллельно в пуле из 3 потоков.
 * 4. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
 */
public class Task_3 {
    private static final int THREADS_COUNT = 3;
    private static final int TASKS_COUNT = 10;

    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Future<String>> futures = new ArrayList<>();
        ReentrantLock locker = new ReentrantLock();

        for (int i = 0; i < TASKS_COUNT; i++) {
            Future<String> submit = pool.submit(new FileDataWriter(locker));
            futures.add(submit);
        }

        List<String> lines = new ArrayList<>();

        for (Future<String> file : futures) {
            lines.add(file.get());
        }

        pool.shutdown();
        System.out.println("\n" + lines);
        System.out.println("Collection total size: " + lines.size());
    }
}

class FileDataWriter implements Callable<String> {
    private static File file = new File("helloWorld.txt").getAbsoluteFile();
    Lock locker;

    FileDataWriter(Lock locker) {
        this.locker = locker;
    }

    @Override
    public String call() throws IOException, InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s is started.\n", threadName);
        List<String> fileNames = new ArrayList<>();

        locker.lock();
        if (!file.exists()) {
            file.createNewFile();
        }

        String lineToWrite = "";
        try (FileWriter fw = new FileWriter(file, true)) {
            lineToWrite = "Hello World. " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            fw.write(lineToWrite);
            fw.write("\n");
            fileNames.add(file.getName());
        }

        Random random = new Random();
        int seconds = random.nextInt(3);
        System.out.printf("%s now sleep for %d seconds.\n", threadName, seconds);
        TimeUnit.SECONDS.sleep(seconds);

        System.out.printf("%s wrote line in file.\n", threadName);
        locker.unlock();

        return lineToWrite;
    }
}
