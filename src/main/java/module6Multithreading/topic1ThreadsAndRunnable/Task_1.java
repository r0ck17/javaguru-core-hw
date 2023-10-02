package module6Multithreading.topic1ThreadsAndRunnable;

import java.util.Random;

/**
 *                          Генератор массивов
 *
 * 1. Создать класс поток, который генерирует массив случайных целых чисел из 10 элементов.
 * 2. Затем находит максимальный элемент, в этом массиве, и выводит на экран в формате:
 *          имя потока, максимальный элемент.Щ
 * 3. Запустить 10 потоков
 */
public class Task_1 {
    private static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        System.out.printf("Thread name: %s. Method main started.\n",
                Thread.currentThread().getName());
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread myThread = new Thread(new RunnableImpl(10));
            myThread.start();
        }
    }
}

class RunnableImpl implements Runnable {
    private final int NUMS_COUNT;

    public RunnableImpl(int numsCount) {
        NUMS_COUNT = numsCount;
    }

    @Override
    public void run() {
        System.out.printf("Thread name: %s. Method run started.\n", Thread.currentThread().getName());
        int[] nums = new int[NUMS_COUNT];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        int maxValue = findMaxValue(nums);

        System.out.printf("Thread name: %s, maxValue: %d\n",
                Thread.currentThread().getName(), maxValue);
    }

    private int findMaxValue(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}
