package module7StreamAPI.topic2StreamAPI;

import java.util.List;
import java.util.stream.Stream;

public class Task_2 {
    private static final double INCHES_TO_CM_COEFFICIENT = 2.54;
    
    public static void main(String[] args) {
        List<Integer> numbers = Stream.iterate(1, i -> ++i)
                .limit(20)
                .toList();
        
        numbers.forEach(inches ->
                System.out.printf("inches: %d. centimeters: %.2f%n",
                        inches, inches * INCHES_TO_CM_COEFFICIENT));

        double sumInCm = numbers.stream()
                .mapToDouble(x -> INCHES_TO_CM_COEFFICIENT * x)
                .sum();

        System.out.printf("%nSum in sum: %.2f%n", sumInCm);
    }
}
