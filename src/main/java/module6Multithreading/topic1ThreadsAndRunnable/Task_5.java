package module6Multithreading.topic1ThreadsAndRunnable;

import java.util.concurrent.TimeUnit;

/**
 *                  Deadlock
 *
 * 1. Создать программу, которая реализует deadlock между тремя потоками
 *
 *                  Comments
 * 1. obj1, obj2, obj3
 * 2. threads:
 *      thread1 -> capture obj1 and want get obj2
 *      thread2 -> capture obj2 and want get obj3
 *      thread3 -> capture obj3 and want get obj1
 *
 */
public class Task_5 {
    public static void main(String[] args) throws InterruptedException {
        Data lock1 = new Data("lock1");
        Data lock2 = new Data("lock2");
        Data lock3 = new Data("lock3");

        Thread thread = new Thread(new Runner(lock1, lock2));
        Thread thread2 = new Thread(new Runner(lock2, lock3));
        Thread thread3 = new Thread(new Runner(lock3, lock1));

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class Runner implements Runnable {
    private Data lock1;
    private Data lock2;

    public Runner(Data lock1, Data lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%S started.\n", threadName);
        synchronized (lock1) {
            System.out.printf("%S captured monitor of object '%S'.\n",
                    threadName, lock1.getName());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                System.out.printf("%S captured monitor of object '%S'.\n",
                        threadName, lock2.getName());
            }
        }
        System.out.printf("%S finished.\n", threadName);
    }
}

class Data {
    private final String name;
    // Some other class fields

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Some other methods with logic
}
