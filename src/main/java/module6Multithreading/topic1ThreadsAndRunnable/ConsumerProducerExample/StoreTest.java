package module6Multithreading.topic1ThreadsAndRunnable.ConsumerProducerExample;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Thread thread = new Thread(producer);
        Thread thread1 = new Thread(consumer);

        thread.start();
        thread1.start();
    }
}
