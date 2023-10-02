package module6Multithreading.topic1ThreadsAndRunnable.Task_6_with_console_log;

import java.util.Deque;

public class Consumer implements Runnable {
    private final int ESTIMATED_CONSUMED_ELEMENTS_COUNT;
    private static int consumedElementsCount = 0;
    private final Deque<Integer> deque;

    public Consumer(Deque<Integer> deque, int estimatedConsumedElementsCount) {
        this.deque = deque;
        this.ESTIMATED_CONSUMED_ELEMENTS_COUNT =
                estimatedConsumedElementsCount;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            synchronized (deque) {
                if (!deque.isEmpty()) {
                    consumedElementsCount++;
                    deque.poll();
                    System.out.printf(
                            "%s consumed element. Size: %d. Total consumed: %d.%n",
                            threadName,
                            deque.size(),
                            consumedElementsCount
                    );
                }
                deque.notify();

                try {
                    System.out.printf("%s is waiting.%n", threadName);
                    deque.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("%s woke up.%n", threadName);

                if (consumedElementsCount == ESTIMATED_CONSUMED_ELEMENTS_COUNT) {
                    deque.notify();
                    break;
                }
            }
        }
        System.out.println(threadName + " terminating.");
    }

    public static int getConsumedElementsCount() {
        return consumedElementsCount;
    }
}
