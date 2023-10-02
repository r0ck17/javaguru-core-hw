package module6Multithreading.topic2CallableAndThreadPool.examples;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;

class CallableTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter line: ");
        String input = scanner.nextLine();
        String[] words = input.split(" ");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        Set<Future<Integer>> set = new HashSet<>();

        for (String word : words) {
            Callable<Integer> callable = new MyCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }

        System.out.printf("The sum of lengths is %s%n", sum);
        pool.shutdown();
    }
}

class MyCallable implements Callable {
    private String word;

    public MyCallable(String word) {
        this.word = word;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ", длинна слова " + word.length());
        return word.length();
    }
}