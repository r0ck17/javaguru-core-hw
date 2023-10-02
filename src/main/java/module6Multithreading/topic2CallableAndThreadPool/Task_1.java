package module6Multithreading.topic2CallableAndThreadPool;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *                      Асинхронный генератор файлов
 *
 * 1. Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками -> засыпает произвольно на 1-3 секунды
 *          результат выполнения – коллекция имен файлов.
 * 2. Запустить 10 задач параллельно в пуле из 3 потоков.
 * 3. Вывести ход программы на экран с указанием имени потока, который выполняет работу.
 */

public class Task_1 {
    private static final int THREADS_COUNT = 3;

    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Future<List<String>>> files = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            Future<List<String>> submit = pool.submit(new FileGenerator());
            files.add(submit);
        }

        List<String> resultList = new ArrayList<>();

        for (Future<List<String>> file : files) {
            resultList.addAll(file.get());
        }

        pool.shutdown();
        System.out.println("\n" + resultList);
        System.out.println("Collection total size: " + resultList.size());
    }
}

class FileGenerator implements Callable<List<String>> {
    private static final String ROOT_PATH = "files";
    private static final int FILES_COUNT = 10;

    @Override
    public List<String> call() throws IOException, InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s is started.\n", threadName);
        List<String> fileNames = new ArrayList<>();

        File dirs = new File(ROOT_PATH).getAbsoluteFile();
        dirs.mkdir();

        for (int i = 0; i < FILES_COUNT; i++) {
            String fileName = threadName + "_file" + (i + 1) + ".txt";
            File file = Path.of(ROOT_PATH, fileName).toAbsolutePath().toFile();

            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            try (OutputStream fos = new FileOutputStream(file)) {
                fos.write(i);
                fos.flush();
                fileNames.add(file.getName());
            }
        }

        long millis = 1000 + (int) (Math.random() * 2000);
        System.out.printf("%s now sleep for %d ms.\n", threadName, millis);
        Thread.sleep(millis);
        System.out.printf("%s is done.\n", threadName);

        return fileNames;
    }
}
