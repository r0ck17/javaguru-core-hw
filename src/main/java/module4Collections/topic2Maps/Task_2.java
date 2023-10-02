package module4Collections.topic2Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ввести текст с клавиатуры.
 *
 * Для текста создать Map, где ключом будет слово, а значение – количество повторений этого слова в тексте.
 * Вывести на консоль Map.
 */
public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Map<String, Integer> wordRepeats = countWords(inputLine);

        System.out.println(wordRepeats);
    }

    private static Map<String, Integer> countWords(String str) {
        String[] words = str.split("\\s*[\\,\\.?!]?\\s+");
        Map<String, Integer> wordRepeats = new HashMap<>();

        for (String word : words) {
            if (isWord(word)) {
                int wordCount = wordRepeats.getOrDefault(word, 0);
                wordRepeats.put(word.toLowerCase(), wordCount + 1);
            }
        }

        return wordRepeats;
    }

    private static boolean isWord(String word) {
        return word.matches("\\w+");
    }
}