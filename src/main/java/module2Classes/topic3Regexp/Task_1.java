package module2Classes.topic3Regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Введите с клавиатуры строку. Найти в строке не только запятые,
 * но и другие знаки препинания. Подсчитать общее их количество.
 */
public class Task_1 {
    public static void main(String[] args) {
        System.out.print ("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int countPunctuation = countPunctuationMarks(str);

        System.out.println("Общее количество знаков препинания: " + countPunctuation);
    }

    public static int countPunctuationMarks(String str) {
        Pattern compile = Pattern.compile("[.,;:!?\\-()\"]");
        Matcher matcher = compile.matcher(str);
        int countMatches = 0;

        while (matcher.find()) {
            countMatches++;
        }

        return countMatches;
    }
}