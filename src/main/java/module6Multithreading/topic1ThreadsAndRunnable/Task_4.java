package module6Multithreading.topic1ThreadsAndRunnable;

import java.util.concurrent.TimeUnit;

/**
 *                      Синхронизированые потоки
 *
 * 1. Создать метод, который печатает название потока и засыпает на 2 секунды.
 * 2. Запустить одновременно 10 потоков.
 * 3. Реализовать механизм синхронизации, чтобы все потоки выполнились последовательно.
 */

public class Task_4 {
    private static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        Thread[] threads = getThreads();
        startThreads(threads);
    }

    private static Thread[] getThreads() {
        Thread[] threads = new Thread[THREADS_COUNT];
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NamePrinter(lock));
        }
        return threads;
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class NamePrinter implements Runnable {
    private Object lock;

    public NamePrinter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("Thread '%s' started.\n", threadName);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Thread '%s' finished work.\n", threadName);
        }

    }
}
