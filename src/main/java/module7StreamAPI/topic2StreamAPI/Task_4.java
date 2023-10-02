package module7StreamAPI.topic2StreamAPI;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_4 {
    private static final int NUMBERS_COUNT = 100;
    private static final int MAX_VALUE = 10;

    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> evenNumbers = Stream.generate(() -> random.nextInt(MAX_VALUE + 1))
                .limit(NUMBERS_COUNT)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toSet());

        System.out.println(evenNumbers);
    }
}
