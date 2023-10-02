package module6Multithreading.topic1ThreadsAndRunnable.ConsumerProducerExample;

public class Store {
    private int item;

    public synchronized void put() {
        while (item >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        item++;
        System.out.println("Producer added 1 item. Size: " + item);
        notify();
    }

    public synchronized void get() {
        while (item < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        item--;
        System.out.println("Supplier get 1 item. Size: " + item);
        notify();
    }
}