package module7StreamAPI.topic2StreamAPI;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Task_3 {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 18;

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(MIN_VALUE, MAX_VALUE + 1)
                .boxed()
                .toList();

        System.out.println(numbers);

        Predicate<Integer> predicate = x -> (x % 3 == 0) && (x % 5 == 0);
        boolean isAnyMatch = numbers.stream()
                .anyMatch(predicate);

        System.out.println("List contains specific number: " + isAnyMatch);
    }
}
