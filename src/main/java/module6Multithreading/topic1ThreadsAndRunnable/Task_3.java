package module6Multithreading.topic1ThreadsAndRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Один List на всех
 * <p>
 * 1. Создать класс Generator extends Thread
 * 2. В конструктор класса передается List ссылка на который сохраняется в классе.
 * 3. В методе run() в list по одному добавляются случайные числа
 * и после каждого добавления поток “засыпает” (sleep) на 200 msec
 * 4. Запустить не менее 4 потоков. В лист должно добавится 100 чисел.
 */

public class Task_3 {
    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        System.out.printf("Thread '%s is started.\n\n", Thread.currentThread().getName());
        ArrayList<Integer> nums = new ArrayList<>();
        Thread[] threads = getThreads(nums);
        startThreads(threads);
        waitUntilAllThreadsDone(threads);
        printCountAddOperations(threads);

        System.out.printf("\nList size: %d\n", nums.size());
        System.out.printf("Thread '%s is finished.\n", Thread.currentThread().getName());
    }

    private static Thread[] getThreads(List<Integer> nums) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < threads.length; i++) {
            Thread objectGenerator = new Generator(nums);
            threads[i] = objectGenerator;
        }

        return threads;
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void waitUntilAllThreadsDone(Thread[] threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void printCountAddOperations(Thread[] threads) {
        for (Thread thread : threads) {
            Generator generator = (Generator) thread;
            System.out.printf("Thread: '%s' count of add operations in list: %d\n",
                    thread.getName(), generator.getCountAddOperations());
        }
    }
}

class Generator extends Thread {
    private static final int MAX_LIST_SIZE = 100;
    private final List<Integer> nums;
    private int countAddOperations;

    Generator(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (nums.size() < MAX_LIST_SIZE) {
            int num = random.nextInt(Byte.MAX_VALUE);
            synchronized (nums) {
                nums.add(num);
            }
            countAddOperations++;
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getCountAddOperations() {
        return countAddOperations;
    }
}