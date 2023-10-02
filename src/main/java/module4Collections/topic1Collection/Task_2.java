package module4Collections.topic1Collection;

import java.util.*;

/**
 * Создать коллекцию, заполнить ее случайными целыми числами.
 * Удалить повторяющиеся числа.
 * Выведите на консоль коллекцию.
 */
public class Task_2 {
    private static final int NUMBERS_COUNT = 10;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(NUMBERS_COUNT);
        fillListWithRandomValues(numbers);

        System.out.printf("Collection:\n%s\n", numbers);

        removeDuplicates(numbers);
        System.out.printf("After removing duplicates:\n%s\n", numbers);
    }

    private static void fillListWithRandomValues(List<Integer> numbers) {
        Random random = new Random();

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers.add(random.nextInt(5));
        }
    }

    private static void removeDuplicates(List<Integer> numbers) {
        Set<Integer> uniqs = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqs.contains(number)) {
                uniqs.add(number);
            } else {
                duplicates.add(number);
            }
        }

        numbers.removeAll(duplicates);
    }
}