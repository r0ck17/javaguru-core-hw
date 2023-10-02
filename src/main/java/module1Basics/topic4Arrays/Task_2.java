package module1Basics.topic4Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Создайте переменную для массива из 10 элементов.
 *
 * Заполните его произвольными значениями целочисленного типа.
 * Найдите максимальный элемент и выведите его индекс.
 */
public class Task_2 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        int max = Integer.MIN_VALUE;
        int indexMax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexMax = i;
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println("index of max element = " + indexMax);
    }
}
