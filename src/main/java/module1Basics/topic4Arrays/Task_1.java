package module1Basics.topic4Arrays;

import java.util.Random;

/**
 * Создайте переменную для массива из 10 элементов.
 *
 * Заполните его произвольными значениями целочисленного типа.
 * Выведите на экран элементы, стоящие на четных позициях.
 */
public class Task_1 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                System.out.println("nums[" + i + "] = " + nums[i]);
            }
        }
    }
}
