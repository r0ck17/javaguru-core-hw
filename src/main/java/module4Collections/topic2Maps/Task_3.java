package module4Collections.topic2Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализовать функцию подсчета количества одинаковых символов в строке:
 *
 * public Map<Character, Integer> getCharsCount(String s)
 */
public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() != 0) {
            Map<Character, Integer> charsCount = getCharsCount(input);

            System.out.println("Количество повторений символов в строке: ");
            for (var entry : charsCount.entrySet()) {
                System.out.printf("'%c' = %d\n", entry.getKey(), entry.getValue());
            }
        } else {
            System.out.println("Пустая строка.");
        }

    }

    public static Map<Character, Integer> getCharsCount(String s) {
        Map<Character, Integer> charsCount = new HashMap<>();

        for (char ch: s.toCharArray()) {
            int count = charsCount.getOrDefault(ch, 0);
            charsCount.put(ch, count + 1);
        }

        return charsCount;
    }
}