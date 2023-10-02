package module6Multithreading.topic2CallableAndThreadPool.examples;

import java.util.concurrent.*;

public class CallableTest1 implements Callable {
    @Override
    public Integer call(){
        return 5;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Callable<Integer> callable = new CallableTest1();
        Future<Integer> future = pool.submit(callable);

        while (!future.isDone()) {
            Thread.sleep(1000);
        }

        System.out.println(future.get());

        pool.shutdown();
    }
}
