package module6Multithreading.topic2CallableAndThreadPool.examples;

public class DeadLockExample {
    public static void main(String[] args) throws InterruptedException {
        Friend alphonse = new Friend("Alphonse");
        Friend gaston = new Friend("Gaston");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                alphonse.bow(gaston);
                System.out.println("Th1: Gaston bowed to Alphonse\n");
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                gaston.bow(alphonse);
                System.out.println("Th2: Gaston waiting Alphonse bowed");
            }
        });

        thread.start();
        thread1.start();
    }

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public synchronized void bow(Friend bower) {
            System.out.printf("%s: %s has bowed to me!%n", name, bower.getName());
            try {
                Thread.sleep(100); // Для увеличения шанса дедлока
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.printf("%s: %s has bowed to me back!%n", name, bower.getName());
        }

        public String getName() {
            return name;
        }
    }
}
