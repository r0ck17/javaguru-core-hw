package module7StreamAPI.topic1Lambda;

import java.util.Objects;
import java.util.function.Predicate;

/**
 *                              Predicate
 * 1. Создать лямбда выражение, которое возвращает значение true,
 *      если строка не null, используя функциональный интерфейс Predicate.
 *
 * 2. Создать лямбда выражение, которое проверяет, что строка не пуста,
 *      используя функциональный интерфейс Predicate.
 *
 * 3. 3. Написать программу, которая проверяет, что строка начинается буквой “J”или “N”
 *      и заканчивается “A”.
 */
public class Task_1 {
    public static void main(String[] args) {
        String[] testData1 = {null, "", "not empty"};
        String[] testData2 = {"JA", "Nfds1fA", "Jfsd_fs1dfA", "asdasA", "Na", null, ""};

        Predicate<String> isNotNull = Objects::nonNull;
        testWordsAndPrintResult(testData1, isNotNull, "not null");

        Predicate<String> isNotEmpty = (str) -> str.length() > 0;
        Predicate<String> isNotEmptyAndNotNull = isNotNull.and(isNotEmpty);

        testWordsAndPrintResult(testData1, isNotEmptyAndNotNull, "empty");

        Predicate<String> isSpecifiedStartAndEnd = (str) -> str.matches("([JN])\\w*A");
        Predicate<String> isSpecifiedStrNotNull = isNotNull.and(isSpecifiedStartAndEnd);

        testWordsAndPrintResult(testData2, isSpecifiedStrNotNull, "matches regexp '(J|N)\\w*A'");
    }

    private static void testWordsAndPrintResult(String[] words, Predicate<String> predicate, String phrase) {
        for (String word : words) {
            System.out.printf("string [%s] is %s = %s%n", word, phrase,predicate.test(word));
        }
        System.out.println();
    }
}
