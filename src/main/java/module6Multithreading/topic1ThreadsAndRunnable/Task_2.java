package module6Multithreading.topic1ThreadsAndRunnable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Генератор файлов
 * 1. Создать класс поток, который создает файл и записать в него
 * произвольно сгенерированный массив из 10 случайных целых чисел.
 * 2. Запустить 5 потоков.
 */
public class Task_2 {
    private static final int THREADS_COUNT = 5;
    private static final String FILE_NAME = "test.txt";

    public static void main(String[] args) {
        System.out.printf("Thread '%s' started.\n", Thread.currentThread().getName());
        startThreads(new Task(FILE_NAME));
        File file = new File(FILE_NAME);
    }

    private static void startThreads(Runnable runnable) {
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}

class Task implements Runnable {
    private static final int NUMS_COUNT = 10;
    private final String FILE_NAME;

    Task(String fileName) {
        this.FILE_NAME = fileName;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("Thread '%s' started.\n", threadName);

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.printf("Thread %s created file '%s'.\n",
                    threadName, FILE_NAME);
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int[] nums = generateArray();

        try (FileWriter fileWriter = new FileWriter(file)) {
            String arrayAsString = getArrayAsStringLine(nums);
            fileWriter.write(arrayAsString);
            System.out.printf("Thread '%s' wrote line '%s' in file.\n",
                    threadName, arrayAsString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] generateArray() {
        int[] nums = new int[NUMS_COUNT];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        return nums;
    }

    private String getArrayAsStringLine(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
            builder.append(" ");
        }

        return builder.toString().trim();
    }
}
