package module6Multithreading.topic1ThreadsAndRunnable.Task_6_with_console_log;

import java.util.Deque;
import java.util.Random;

public class Producer implements Runnable {
    private final int ESTIMATED_CONSUMED_ELEMENTS_COUNT;
    private final int MINIMAL_SIZE_TO_START = 80;
    private final Deque<Integer> deque;

    public Producer(Deque<Integer> deque, int estimatedConsumedElementsCount) {
        this.deque = deque;
        this.ESTIMATED_CONSUMED_ELEMENTS_COUNT =
                estimatedConsumedElementsCount;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            synchronized (deque) {
                if (deque.size() <= MINIMAL_SIZE_TO_START) {
                    Random random = new Random();
                    deque.offerLast(random.nextInt(100));
                    System.out.printf("%s added item in queue. Size: %d%n",
                            threadName, deque.size());
                }
                deque.notify();
                try {
                    System.out.printf("%s is waiting.%n", threadName);
                    deque.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.printf("%s woke up.%n", threadName);

                if (Consumer.getConsumedElementsCount()
                        == ESTIMATED_CONSUMED_ELEMENTS_COUNT) {
                    deque.notify();
                    break;
                }
            }
        }
        System.out.printf("%s terminating.%n", threadName);
    }
}
