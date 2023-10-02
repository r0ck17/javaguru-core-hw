package module2Classes.topic3Regexp;

import java.util.Scanner;

/**
 * Введите с клавиатуры текст. Подсчитать количество слов в тексте.
 * Учесть, что слова могут разделяться несколькими пробелами,
 * в начале и конце текста также могут быть пробелы, но могут и отсутствовать.
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.print ("Введите текст: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int countPunctuation = countWords(str);

        System.out.println("Общее количество слов в тексте: " + countPunctuation);
    }

    public static int countWords(String str) {
        String[] words = str.trim().split("\\s+");
        return words.length;
    }
}
