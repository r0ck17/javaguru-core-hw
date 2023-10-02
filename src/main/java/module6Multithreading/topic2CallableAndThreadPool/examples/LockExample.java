package module6Multithreading.topic2CallableAndThreadPool.examples;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static final int COUNT_THREADS = 3;

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();

        for (int i = 0; i < COUNT_THREADS; i++) {
            Thread thread = new Thread(new CountThread(commonResource, locker));
            thread.start();
        }
    }
}

class CommonResource {
    int items = 0;
}

class CountThread implements Runnable {
    CommonResource res;
    ReentrantLock locker;

    public CountThread(CommonResource res, ReentrantLock locker) {
        this.res = res;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock(); // устанавливаем блокировку
        try {
            res.items = 1;
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d%n", Thread.currentThread().getName(), res.items);
                res.items++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}