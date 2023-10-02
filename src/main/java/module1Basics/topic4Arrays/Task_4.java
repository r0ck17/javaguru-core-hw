package module1Basics.topic4Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Задание: Убрать одинаковые элементы массива (каждое значение должно присутствовать в единственном экземпляре)
 */
public class Task_4 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(9);
        }

        System.out.println("Первоначальный массив:\n" + Arrays.toString(nums));
        int[] uniqNums = removeAllDuplicates(nums);
        System.out.println("\nМассив после удаления всех дубликатов:\n" + Arrays.toString(uniqNums));
    }

    public static int[] removeAllDuplicates(int[] nums) {
        int length = nums.length;
        boolean[] indexDuplicatedNums = new boolean[length];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    indexDuplicatedNums[i] = true;
                    indexDuplicatedNums[j] = true;
                }
            }
        }

        int[] tempUniqNums = new int[length];
        int uniqNumsCount = 0;
        for (int i = 0; i < length; i++) {
            if (!indexDuplicatedNums[i]) {
                tempUniqNums[uniqNumsCount] = nums[i];
                uniqNumsCount++;
            }
        }
        int[] uniqNums = new int[uniqNumsCount];
        System.arraycopy(tempUniqNums, 0, uniqNums, 0, uniqNumsCount);
        return uniqNums;
    }
}
