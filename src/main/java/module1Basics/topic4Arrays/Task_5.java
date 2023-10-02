package module1Basics.topic4Arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 1. Получить через Scanner размер тестового массива
 * 2. Заполнить массив случайными целочисленными значениями
 * 3. Написать метод, удаляющий из массива локальные максимумы.
 * 4. Вывести на экран изначальный массив и массив после удаления локальных максимумов
 *
 * Локальный максимум - элемент, который больше предыдущего и следующего,
 * если элемент стоит в начале или в конце массива, то больше только следующего
 * или только предыдущего соответственно.
 *
 * Пример:
 * Начальный массив: [5, 3, -10, 4, -4, 80, 20]
 * Поcле удаления локальных максимумов: [3, -10, -4, 20]
 */
public class Task_5 {
    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        while (size < 1) {
            System.out.print("Некорректный ввод. Введите целое число от 1 и выше: ");
            size = scanner.nextInt();
        }

        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10);
        }

        System.out.println("\nПервоначальный массив:\n" + Arrays.toString(nums));
        int[] uniqNums = removeAllLocalMaxima(nums);
        System.out.println("\nМассив после удаления локальных максимумов:\n" + Arrays.toString(uniqNums));
    }

    public static int[] removeAllLocalMaxima(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return new int[]{nums[0]};
        }

        boolean[] isLocalMaxima = new boolean[length];

        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                isLocalMaxima[i] = true;
            }
        }

        if (nums[0] > nums[1]) {
            isLocalMaxima[0] = true;
        }

        if (nums[length - 1] > nums[length - 2]) {
            isLocalMaxima[length - 1] = true;
        }

        int[] tempUniqNums = new int[length];
        int resultArrElementsCount = 0;
        for (int i = 0; i < length; i++) {
            if (!isLocalMaxima[i]) {
                tempUniqNums[resultArrElementsCount] = nums[i];
                resultArrElementsCount++;
            }
        }

        int[] uniqNums = new int[resultArrElementsCount];
        System.arraycopy(tempUniqNums, 0, uniqNums, 0, resultArrElementsCount);
        return uniqNums;
    }
}
