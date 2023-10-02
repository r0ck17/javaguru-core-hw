package module2Classes.topic3Regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Введите с клавиатуры текст. Выведите на экран текст,
 * составленный из последних букв всех слов из исходного текста.
 */

public class Task_3 {
    public static void main(String[] args) {
        System.out.print ("Введите текст: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String wordFromLastChars = getWordFromLastChars(str);

        System.out.println("\nТекст, составленный из последних букв всех слов: " + wordFromLastChars);
    }

    public static String getWordFromLastChars(String str) {
        String[] words = str.trim().split("\\s+");

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.matches("[a-zA-Z]{2,}")) {
                char lastChar = word.charAt(word.length() - 1);
                stringBuilder.append(lastChar);
            }
        }
        return stringBuilder.toString();
    }

    // Не реализованный правильно метод, оставлен только для демонстрации сути вопроса первого подхода
    public static String getWordFromLastChars_Old(String str) {
        Pattern pattern = Pattern.compile("(?<=[a-zA-Z])[a-zA-Z]\\b");
        Matcher matcher = pattern.matcher(str);

        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }
        return stringBuilder.toString();
    }
}
