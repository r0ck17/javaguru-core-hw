package module9Exam.Task_2;

import java.util.Arrays;
import java.util.Random;

/**
 * Сгенерировать массив случайных целых чисел, величина которых, по модулю, не превышает 300 (-300 ... 300). Число элементов массива равно 10.
 *
 * Найти максимальное и минимальное числа в массиве и вывести на экран.
 *
 * Заменить максимальный элемент на минимальный и вывести на экран массив.
 */
public class AppRunner {
    private static final int MAX_NUMBER = 300;
    private static final int MIN_NUMBER = -300;
    private static final int NUMBERS_COUNT = 10;

    public static void main(String[] args) {
        int[] nums = generateArray();
        System.out.println(Arrays.toString(nums));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minIndex = i;
            } else if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        System.out.printf("MinIndex = %d. MaxIndex = %d%n", minIndex, maxIndex);
        swapElements(nums, maxIndex, minIndex);
        System.out.println(Arrays.toString(nums));
    }

    private static void swapElements(int[] nums, int maxIndex, int minIndex) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[maxIndex];
        nums[maxIndex] = temp;
    }

    private static int[] generateArray() {
        Random random = new Random();
        int[] nums = new int[NUMBERS_COUNT];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        }
        return nums;
    }
}