package module6Multithreading.topic1ThreadsAndRunnable.Task_6_with_console_log;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class AppRunner {
    private static final int ESTIMATED_CONSUMED_ELEMENTS_COUNT = 10_000;
    private static final int INITIAL_QUEUE_SIZE = 200;
    private static final int PRODUCING_THREADS_COUNT = 3;
    private static final int CONSUMING_THREADS_COUNT = 2;

    public static void main(String[] args) {
        Deque<Integer> store = getDeque();

        Thread[] producers = getProducingThreads(store);
        Thread[] consumers = getConsumingThreads(store);

        startThreads(producers);
        startThreads(consumers);

        waitFinishThreads(producers);
        waitFinishThreads(consumers);

        System.out.printf("%nDeque size: %d%n", store.size());
        System.out.printf("Consumed elements count: %d%n",
                Consumer.getConsumedElementsCount());
    }

    private static Deque<Integer> getDeque() {
        Deque<Integer> nums = new ArrayDeque<>();
        Random random = new Random();
        for (int i = 0; i < INITIAL_QUEUE_SIZE; i++) {
            nums.offerLast(random.nextInt(100));
        }

        return nums;
    }

    private static Thread[] getProducingThreads(Deque<Integer> deque) {
        Thread[] producers = new Thread[PRODUCING_THREADS_COUNT];

        for (int i = 0; i < producers.length; i++) {
            Runnable task = new Producer(deque, ESTIMATED_CONSUMED_ELEMENTS_COUNT);
            producers[i] = new Thread(task);
            producers[i].setName("Thread №" + (i + 1) + "(producer)");
        }

        return producers;
    }

    private static Thread[] getConsumingThreads(Deque<Integer> deque) {
        Thread[] producers = new Thread[CONSUMING_THREADS_COUNT];

        for (int i = 0; i < producers.length; i++) {
            Runnable task = new Consumer(deque, ESTIMATED_CONSUMED_ELEMENTS_COUNT);
            producers[i] = new Thread(task);
            producers[i].setName("Thread №" + (i + 1) + "(consumer)");
        }

        return producers;
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void waitFinishThreads(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
