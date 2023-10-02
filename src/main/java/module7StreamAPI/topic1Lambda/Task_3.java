package module7StreamAPI.topic1Lambda;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 *                          Supplier
 * Написать лямбда выражение, которое возвращает случайное число от 0 до 10.
 */
public class Task_3 {
    public static void main(String[] args) {
        final int MAX_VALUE = 10;
        Supplier<Integer> numberGenerator = () -> (int) (Math.random() * MAX_VALUE + 1);

        int[] nums = generateArray(numberGenerator, 5);

        System.out.println("Generated array: " + Arrays.toString(nums));
    }

    private static int[] generateArray(Supplier<Integer> generator, int arraySize) {
        if (arraySize < 0) {
            throw new IllegalArgumentException();
        }

        int[] nums = new int[arraySize];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = generator.get();
        }

        return nums;
    }
}