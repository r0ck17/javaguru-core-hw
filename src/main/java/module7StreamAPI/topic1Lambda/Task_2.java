package module7StreamAPI.topic1Lambda;

import java.util.function.Function;

/**                 Function
 * Написать лямбда выражение, которое принимает на вход число и возвращает значение “Положительное число”,
 * “Отрицательное число” или  “Ноль”.
 */
public class Task_2 {
    public static void main(String[] args) {
        Function<Integer, String> checkNumForSign = (num) -> {
            if (num.doubleValue() == 0) {
                return "Ноль";
            }
            return num > 0 ? "Положительное число" : "Отрицательное число";
        };

        System.out.println(checkNumForSign.apply(1));
        System.out.println(checkNumForSign.apply(0));
        System.out.println(checkNumForSign.apply(1));
    }
}
